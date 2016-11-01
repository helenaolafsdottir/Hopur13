package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import project.service.StringManipulationService;

@Controller
public class UserController {

	 // Instance Variables
    StringManipulationService stringService;

    // Dependency Injection
    @Autowired
    public UserController(StringManipulationService stringService) {
        this.stringService = stringService;
    }
}
