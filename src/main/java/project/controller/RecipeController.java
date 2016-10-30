package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import project.service.StringManipulationService;

@Controller
public class RecipeController {

	
	 // Instance Variables
    StringManipulationService stringService;

    // Dependency Injection
    @Autowired
    public RecipeController(StringManipulationService stringService) {
        this.stringService = stringService;
    }
    
}
