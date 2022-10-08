/**
 * 
 */
package com.fundamentos.springboot.springdemo.component;

import org.springframework.stereotype.Component;

/**
 * @author juaneins_uio
 *
 */
@Component
public class ComponentImplement implements ComponentDependency {

	@Override
	public void greeting() {
		System.out.println("Hello world! from component!!");
		
	}
	
	
	

}
