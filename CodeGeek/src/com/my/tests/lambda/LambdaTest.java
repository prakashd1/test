package com.my.tests.lambda;

import com.my.common.interfaces.Math;


public class LambdaTest {

	public static void main(String[] args) {
		
		Runnable r2 = () -> {
			System.out.println("Hello world two!");
		};
		new Thread(r2).start();

		Math m=(int a,int b) -> a+b;
		System.out.println(m.add(10, 20));
	}
}
