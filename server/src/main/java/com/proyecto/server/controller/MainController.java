
package com.proyecto.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author shady
 */

/**
 * Esta Clase es la principal de todos los controladores.
 * 
 */
@Controller
public class MainController {
    
	@RequestMapping("/")
	@ResponseBody
	public String index() {
		String response = "Bienvenido al Sistema";
		 
		
		return response;
	}
}



