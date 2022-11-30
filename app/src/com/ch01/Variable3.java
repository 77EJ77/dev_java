package com.ch01;

public class Variable3 {
	public static void main(String[] args) {
		//String은 원시타입인가? 아님 참조형타입인가?
		//String은 참조형 타입이지만 예외적으로 값이 출력됨.
		String name = "이순신";
		System.out.println(name);
//		int i = (int)name;
		int age = 30;
		String s_age = "30";
		System.out.println(age + 1);//31
		System.out.println(s_age + 1);//31 or 301
		System.out.println(10 + 1);//11
		System.out.println(10 + "1");//101
	}

}
