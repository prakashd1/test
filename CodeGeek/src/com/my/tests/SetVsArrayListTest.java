package com.my.tests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * @author Prakash This program creates random strings with the 3 characters as
 *         it contains 3 loops and adds them to HashSet and Arrylist, it adds
 *         5000 such strings, and then adds String named "Prakash" then
 *         calculates time required.
 *
 */
public class SetVsArrayListTest {

	public static void main(String[] args) {

		ArrayList<String> arrayList = new ArrayList<String>();
		HashSet<String> hashSet = new HashSet<String>();

		addElemetoCollection(arrayList, 15000);
		addElemetoCollection(hashSet, 15000);

		
		System.out.println("total elements in array list " + arrayList.size());
		System.out.println("total elements in hash set" + hashSet.size());

		addStringtoCollection(arrayList, "Prakash");
		addStringtoCollection(hashSet, "Prakash");

		// Now we have added 5000 elements into collections lets add String
		// named prakash and check time,

	}

	public  static Collection<String> addElemetoCollection(Collection<String> collection,int count){
		
		int x = 0;

		for (int j = 97; j <= 122; j++) {

			for (int k = 97; k <= 122; k++) {

				for (int l = 97; l < 122; l++) {
					char a = (char) j;
					char b = (char) k;
					char c = (char) l;
					x++;
					String st = "" + a + "" + b + "" + c;
					collection.add(st);

					if (x == count)
						return collection;
				}
			}

		}
		
		return collection;
		
	}
	public static void addStringtoCollection(Collection<String> c, String st) {
		long startTime = System.currentTimeMillis();
		System.out.println("trying to add into " + c.getClass());
		c.add("Prakash");
		long endTime = System.currentTimeMillis();
		System.out.println("total time required " + (endTime - startTime) +" ms");

	}
}
