package project;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import project.persistence.entities.User;
import project.service.UserService;

@Component
public class CreateRecipeValidator implements Validator{
	@Autowired
	private RecipeService recipeService;
	
	@Override
	public boolean supports(Class<?> aClass){
		return User.class.equals(aClass);
	}
	
	@Override
	public void validate(Object o, Errors errors) {
		User user = (User) o;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty");
		if (user.getUserName().length() < 6 || user.getUserName().length() > 32 ) {
			errors.rejectValue("userName", "Size.user.userName");
		}
		
		if(!userService.findByName(user.getUserName()).isEmpty()){
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
	
	public boolean isValidEmailAddress(String emailAddress){ 
        String expression="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"; 
        CharSequence inputStr = emailAddress; 
        Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE); 
        Matcher matcher = pattern.matcher(inputStr); 
        return matcher.matches(); 
    }  

}
