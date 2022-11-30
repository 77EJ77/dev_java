package com.ch01;

public class HapExam {

	public static void main(String[] args) {
		System.out.println("1~100 합 : " + sum(100));
	}
	
	static int sum(int num) {
		int sum = 0;
		for(int i = 1; i <= num; i++)
			sum += i;
		return sum;
	}

}
