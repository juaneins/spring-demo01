/**
 * 
 */
package com.fundamentos.springboot.springdemo.bean;

/**
 * @author juaneins_uio
 *
 */
public class MyBeanWithPropertiesImplement implements MyBeanWithProperties {
	
	private String name;
	private String lastName;
	
	public MyBeanWithPropertiesImplement(String name, String lastName) {		
		this.name = name;
		this.lastName = lastName;
	}

	@Override
	public String function() {		
		return name + " - " + lastName;
	}

}
