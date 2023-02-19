package net.javaguides.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {
	
	@GetMapping
	public String welcomeApi() {
		
		return "<html>\r\n" + 
				"<head><title>WelcomeAPI</title></head>\r\n" + 
				"<body>\r\n" + 
				"<div style=\"text-align: center;\"><h4 style=\"color: green;\">Success</h4></div>\r\n" + 
				"</body>\r\n" + 
				"</html>\r\n" + 
				"";
					
				  
			   
		
	}

}
