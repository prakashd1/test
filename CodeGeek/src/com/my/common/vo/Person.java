package com.my.common.vo;

public class Person {
	private String firstName;
	private String lastName;
	private int age;

	public static class Builder {

		private String firstName = "";
		private String lastName = "";
		private int age = 0;

		public Person.Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Person.Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Person.Builder age(int val) {
			age = val;
			return this;
		}

		public Person build() {
			return new Person(this);
		}
	}

	private Person() {
		super();
	}

	private Person(Person.Builder builder) {
		firstName = builder.firstName;
		lastName = builder.lastName;
		age = builder.age;

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public void print() {
		System.out.println("\nName: " + firstName + " " + lastName + "\n"
				+ "Age: " + age + "\n");
	}

	@Override
	public String toString() {
		return "Name: " + firstName + " " + lastName + "\n" + "Age: " + age
				+ "\n";
	}

}
