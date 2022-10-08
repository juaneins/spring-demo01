/**
 * 
 */
package com.fundamentos.springboot.springdemo.bean;

/**
 * @author juaneins_uio
 *
 */
public class MyOperationImplement implements MyOperation {

	@Override
	public int sum(int number) {		
		return number + 1;
	}

}
