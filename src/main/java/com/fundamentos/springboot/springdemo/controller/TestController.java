/**
 * 
 */
package com.fundamentos.springboot.springdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author juaneins_uio
 *
 */
@Controller
public class TestController {
	@RequestMapping
	@ResponseBody
	public ResponseEntity<String> function() {
		return new ResponseEntity<>("Hello from controller", HttpStatus.OK);
	}
	
}
