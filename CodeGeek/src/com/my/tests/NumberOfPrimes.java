package com.my.tests;

import java.util.Scanner;

/**
 * 
 * @author prakash
 * This program will calculate number of primes in a given integer range
 */
public class NumberOfPrimes {

	static int getNumberOfPrimes(int n) {

		int numberOfPrimes = 0;
			for (; n>1; n--) {

				if(isPrime(n))
					numberOfPrimes++;
			}

		

		return numberOfPrimes;

	}
	
	static boolean isPrime(int n){
		for (int i = 2; i < n; i++) {

			if(n%i==0)
			{
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.print("Enter integer to calculate number of primes from zero:-" );
		Scanner in = new Scanner(System.in);
		int res;
		int _a;
		_a = in.nextInt();
		res = getNumberOfPrimes(_a);
		System.out.println("Total number of primes in given range are:-"+res);
		
		in.close();

	}

}