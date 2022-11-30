package com.ch01;

public class HapExam4 extends Object{

	public static void main(String[] args) {
		//1부터 5까지 세며 짝수의 합을 구하시오.
		int sum = 0;
		for(int i = 1; i <= 6; i++) {
			if(i%2 == 0) sum += i;
		}
		System.out.println(sum);
	}

}
