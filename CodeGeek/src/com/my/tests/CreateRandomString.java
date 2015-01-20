package com.my.tests;

import java.util.Scanner;


/**
 * 
 * @author Prakash
 *  This program creates random strings with the 3 characters as it contains 3 loops
 *  also there is delay that has been added in order to keep track of console.. if there is an requirement, you can 
 *  remove the delay
 *
 */
public class CreateRandomString {

	public static void main(String[] args) {

		int x = 0;
		Scanner in = new java.util.Scanner(System.in);

		for (int j = 97; j <= 122; j++) {

			for (int k = 97; k <= 122; k++) {
				char a = (char) j;
				char b = (char) k;
			
				

				

				for (int l = 97; l < 122; l++) {
					x++;
					System.out.println("p"+a + "" + b + ""  + "y.com");
					
					if (x % 1000 == 0) {
						System.out.println("press enter to continue");
						in.nextLine();
						
					}

				}
			}

		}

	}
}
