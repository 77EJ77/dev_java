package com.ch01;
//char < byte < short < int < long < float < double <- 표현할 수 있는 값의 범위가 더 넓음
//boolean
public class Variable2 {

	public static void main(String[] args) {
		int i = 2;
		int j = i;//j = 2;
		System.out.println(j);
		System.out.println(i==j);//true
		System.out.println(i!=j);//false
		double d = 2.4;
		//대입연산자 오른쪽에 더 큰 타입이 오는 것은 안됨.
		//캐스팅 연산자. 괄호가 변수명 앞에 오면 형전환 연산자.
		//강제 형변환
		j = (int)d;
		System.out.println(j);
		boolean isOk = false;
		//j = (int)isOk; 정수형과 boolean은 강제 형변환이 불가함.
	}
}
