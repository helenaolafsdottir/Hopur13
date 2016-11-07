package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:httpErrorCodes.properties")
public class ErrorService {
	@Autowired
	private Environment env;
	/**
	 * the error message is generated
	 * @param error_code
	 * @return
	 */
	public String generateErrorMessage(final int error_code){
		String message="";
			//gets message for specific errorcode from property file
			switch(error_code){
				case 400: message=env.getProperty("400");
					break;
				case 401: message=env.getProperty("401");
					break;
				case 404: message=env.getProperty("404");
					break;
				case 500: message=env.getProperty("500");
					break;
				default: message="Unknown error";
			}
			return message;
	}
}
