package project.controller.MobileController;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import project.UserValidator;
import project.persistence.entities.Recipe;
import project.persistence.entities.User;
import project.persistence.entities.UserRole;
import project.service.RecipeService;
import project.service.UserService;

@RestController
	public class UserMobController {
	
	UserService userService;
	RecipeService recipeService;
	BCryptPasswordEncoder passwordEncoder;
	UserValidator userValidator;
	
	
	@Autowired
	public UserMobController(UserService userService, BCryptPasswordEncoder passwordEncoder, UserValidator userValidator, RecipeService recipeService){
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
		this.userValidator = userValidator;
		this.recipeService = recipeService;
	}
	
	
	//userbla GET
	@RequestMapping(value="/m/createuser", method = RequestMethod.GET)
	public @ResponseBody User createUser(@RequestParam String username){
		return userService.findByUserName(username);
	}
	
	public User parseUserData(String jsonString) throws JSONException {
		System.out.println("jsonStr:  " + jsonString);
	    JSONObject jsonObject = new JSONObject(jsonString);
		User user = new User();
		//formRecipe.setInstructions(jsonObject.getString("Instructions"));
		user.setUserName(jsonObject.getString("userName"));
		user.setPassword(jsonObject.getString("password"));
		user.setPasswordConfirm(jsonObject.getString("passwordConfirm"));
		user.setEmail(jsonObject.getString("email"));
		user.setName(jsonObject.getString("name"));
		
		return user;
	}
	
	@RequestMapping(value="/m/createuser", method = RequestMethod.POST)
	public ResponseEntity<String> createuser(@RequestBody String jsonString) throws JSONException {

		User formUser = this.parseUserData(jsonString);
		JSONObject jsonObject = this.userValidator.validateAndroid(formUser);
		if(jsonObject.length() > 0){
			return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.OK);
		}
		//create date
		Date createDate = new Date();
		//set create date in formUser
		formUser.setCreateDate(createDate);
		//the user starts as enabled user
		formUser.setEnabled(1);
		//validates the user
		//userValidator.validate(formUser, bindingResult);
		//if validation fails, return to form
		/*if(bindingResult.hasErrors()){
			return "user/Users";
		}*/
		//get password
		String unencodedPassword = formUser.getPassword();
		//password is encoded
		String encodedPassword = passwordEncoder.encode(unencodedPassword);
		//the encoded password is put into formUser
		formUser.setPassword(encodedPassword);
		formUser.setPasswordConfirm(encodedPassword);
		
		/*if(userService.findByEmail(formUser.getEmail()) != null){
			model.addAttribute("resultMessage", "Email already exists");
			return "user/Users";
		}
		if(userService.findByUserName(formUser.getUserName()) != null){
			model.addAttribute("resultMessage", "Username already exists");
		}*/
		//the formUser is saved and the saved user returned
		User savedUser = userService.save(formUser);
		//get id from the saved user
		Long savedId = savedUser.getId();
		//role is set as ROLE_USER
		String role = "ROLE_USER";
		//userRole for saved user is created
		UserRole userRole = new UserRole(savedId, role);
		//userRole for saved user is saved
		UserRole savedUserRole = userService.save(userRole);
		
		//get username
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		//loggedInUser is added to model
		//model.addAttribute("loggedInUser", loggedInUser);
		//user is directed to login page
		
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}
	

	@RequestMapping(value ="/m/myrecipes", method = RequestMethod.GET)
	public @ResponseBody List<Recipe> myRecipes(@RequestParam @NotNull String username){
		
		
		return recipeService.findByUsername(username);
		}
	

	
	@RequestMapping(value="/m/changePassword", method=RequestMethod.POST)
	public String changePasswordViewPost(Model model, @RequestParam("resetPassword") String resetPassword, @RequestParam("resetPasswordAgain") String resetPasswordAgain){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName();
		model.addAttribute("loggedInUser", loggedInUser);
		User user = userService.findByUserName(loggedInUser);
		if(!resetPassword.equals(resetPasswordAgain)){
			model.addAttribute("resultMessage", "Passwords do not match!");
			return "user/ChangePassword";
		}
		if(resetPassword.length()<8){
			model.addAttribute("resultMessage", "Password has to be longer than 7 letters!");
			return "user/ChangePassword";
		}
		String encodedResetPassword = passwordEncoder.encode(resetPassword);
		user.setPassword(encodedResetPassword);
		user.setPasswordConfirm(encodedResetPassword);
		userService.save(user);
		model.addAttribute("resultMessage", "Password has been reset!");
		return "[]";
	}
	
	@RequestMapping(value="/m/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestBody String jsonString) throws JSONException {
		JSONObject jsonObject = new JSONObject(jsonString);
		String loginUsername = jsonObject.getString("userName");
		String loginPassword = jsonObject.getString("password");
		String encodedLoginPassword = passwordEncoder.encode(loginPassword);
		
		if(userService.findByUserName(loginUsername)==null){
			return new ResponseEntity<String>("No user with that username", HttpStatus.OK);
		}
		
		User user = userService.findByUserName(loginUsername);
		String userPassword = user.getPassword();
		
		if(passwordEncoder.matches(loginPassword, userPassword)){
			return new ResponseEntity<String>("OK", HttpStatus.OK);
		}
		
		
		return new ResponseEntity<String>("No user with that username and password", HttpStatus.OK);
	}
	
	
}
