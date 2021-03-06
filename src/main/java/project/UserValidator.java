package project;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import project.persistence.entities.User;
import project.service.UserService;

@Component
public class UserValidator implements Validator{
	@Autowired
	private UserService userService;
	
	@Override
	public boolean supports(Class<?> aClass){
		return User.class.equals(aClass);
	}
	
	public JSONObject validateAndroid(User user) throws JSONException{
		JSONObject jsonObject = new JSONObject();
		if (user.getUserName().length() <= 3 || user.getUserName().length() > 32 ) {
			jsonObject.append("userName", "Username has to be between 4 and 32 letters");
		}
		
		if(userService.findByUserName(user.getUserName())!= null){
			jsonObject.append("userName", "Username is taken");
		}
		
		if(!user.getPasswordConfirm().equals(user.getPassword())) {
			jsonObject.append("passwordConfirm", "Passwords do not match");
		}
		
		if(!isValidEmailAddress(user.getEmail())){
			jsonObject.append("email", "Email not valid");
		}
		if(userService.findByEmail(user.getEmail()) != null){
			jsonObject.append("email", "Email address is taken");
		}
		return jsonObject;
	}
	
	
	/**
	 * This method validates the user
	 */
	@Override
	public void validate(Object o, Errors errors) {
		User user = (User) o;
		//if(user != null) return;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty");
		if (user.getUserName().length() <= 3 || user.getUserName().length() > 32 ) {
			errors.rejectValue("userName", "Size.user.userName");
		}
		
		if(userService.findByUserName(user.getUserName())!= null){
			errors.rejectValue("userName", "Duplicate.user.userName");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
			errors.rejectValue("password", "Size.user.password");
		}
		
		if(!user.getPasswordConfirm().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirm", "Diff.user.passwordConfirm");
		}
		
		if(!isValidEmailAddress(user.getEmail())){
			errors.rejectValue("email", "NotCorrectEmail.user.email");
		}
		
	}
	

	/**
	 * Checks if email address is valid
	 * @param emailAddress is the specific email
	 * @return if the email is valid or not
	 */
	public boolean isValidEmailAddress(String emailAddress){ 
        String expression="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"; 
        CharSequence inputStr = emailAddress; 
        Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE); 
        Matcher matcher = pattern.matcher(inputStr); 
        return matcher.matches(); 
    }  

}
