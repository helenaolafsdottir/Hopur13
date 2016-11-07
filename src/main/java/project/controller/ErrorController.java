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
	/**
	 * Is called when Request mapping url is accessed with GET
	 * Handles and prints out errors
	 * @param model
	 * @param request
	 * @return errorPage jsp
	 */
	@RequestMapping(value="/errors", method=RequestMethod.GET)
	public String renderErrorPage(final Model model, final HttpServletRequest request){
		// get the HttpStatusCode of the request
		final int error_code = getHttpStatusCode(request);
		//error_message is generated using the error_code
		final String error_message=errorService.generateErrorMessage(error_code);
		//get the logged in user
		String loggedInUser = request.getRemoteUser();
		model.addAttribute("loggedInUser", loggedInUser);
		//error message is added to model	
		model.addAttribute("errorMsg", error_message);
		//errorPage jsp
		return "errors/errorPage";
	}
	/**
	 * gets the HttpStatusCode
	 * @param request
	 * @return
	 */
	private int getHttpStatusCode(final HttpServletRequest request){
		return(int) request.getAttribute("javax.servlet.error.status_code");
	}
}
