package com.mkyong.rest;

import java.util.Arrays;

public class Product {

	String name;
	int[] numbers;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getNumbers() {
		return numbers;
	}
	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", numbers=" + Arrays.toString(numbers) + "]";
	}
	
	
}