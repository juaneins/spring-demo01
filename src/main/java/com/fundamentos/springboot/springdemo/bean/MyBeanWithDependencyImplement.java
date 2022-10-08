/**
 * 
 */
package com.fundamentos.springboot.springdemo.bean;

/**
 * @author juaneins_uio
 *
 */
public class MyBeanWithDependencyImplement implements MyBeanWithDependency {

	private MyOperation myOperation;

	public MyBeanWithDependencyImplement(MyOperation myOperation) {
		this.myOperation = myOperation;
	}

	@Override
	public void printWithDependency() {
		System.out.println("hello from MyBeanWithDependencyImplement!!");
		System.out.println("Sum: " + myOperation.sum(10));
	}

}
