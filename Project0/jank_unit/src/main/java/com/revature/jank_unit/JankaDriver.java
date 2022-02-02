package com.revature.jank_unit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JankaDriver {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		System.out.println("Running tests....");
		int passed = 0, failed = 0;
		
		try {
			Class<?> testSuiteClass = Class.forName("com.revature.jank_unit.CalcTestSuite");
			
			for(Method classMethod : testSuiteClass.getMethods()) {
				if(classMethod.isAnnotationPresent(Test.class)) {
					try {
						classMethod.invoke(testSuiteClass.newInstance());
						passed++;
					} catch (AssertionException | InvocationTargetException e) {
						System.out.println(e.getMessage());
						failed++;
					}
				}
			}
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
			failed++;
		}
		
		System.out.println();

	}
	
	public static void assertThat(boolean condition) {
		if(!condition) {
			throw new AssertionException("Assertion not met");
		}
	}

}
