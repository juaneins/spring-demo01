/**
 * 
 */
package com.fundamentos.springboot.springdemo.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author juaneins_uio
 *
 */
public class MyBeanWithDependencyImplement implements MyBeanWithDependency {
	
	private final Log logger = LogFactory.getLog(MyBeanWithDependencyImplement.class);

	private MyOperation myOperation;

	public MyBeanWithDependencyImplement(MyOperation myOperation) {
		this.myOperation = myOperation;
	}

	@Override
	public void printWithDependency() {
		logger.info("In printWithDependency");
		logger.debug("myOperation.sum(10)");
		System.out.println("hello from MyBeanWithDependencyImplement!!");
		System.out.println("Sum: " + myOperation.sum(10));
	}

}
