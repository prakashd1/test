package com.my.patterns;

import com.my.common.vo.Person;

public class Builder {

	public static void main(String[] args) {
		
		Person p = new Person.Builder().firstName("Prakash").lastName("Dayaramani").age(30).build();
		System.out.println(p);
		
		
	}
}
