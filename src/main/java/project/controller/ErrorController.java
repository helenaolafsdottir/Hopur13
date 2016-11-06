package project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.service.ErrorService;

@Controller
public class ErrorController {
	@Autowired
	private ErrorService errorService;
	
	@RequestMapping(value="/errors", method=RequestMethod.GET)
	public String renderErrorPage(final Model model, final HttpServletRequest request){
		
		final int error_code = getHttpStatusCode(request);
		
		final String error_message=errorService.generateErrorMessage(error_code);
		
		String loggedInUser = request.getRemoteUser();
		model.addAttribute("loggedInUser", loggedInUser);
			
		model.addAttribute("errorMsg", error_message);
		return "errors/errorPage";
	}
	
	private int getHttpStatusCode(final HttpServletRequest request){
		return(int) request.getAttribute("javax.servlet.error.status_code");
	}
}
