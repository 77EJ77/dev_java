package app.src.com.ch01;

public class P13 {

	public static void main(String[] args) {
		System.out.println(5 + 0.5);// 상수로 하였다. 변수를 사용하지 않은 코드임.
		byte b = 5;
		float f = 0.5f;
		// byte + float => float이다
		// byte - float => float이다 -> int-float연산을 함
		System.out.println(b + f);// 변수를 활용하였다
		System.out.println(275);
		System.out.println(275 / 3);// int/int -> int
		System.out.println(275 / 3.0);// 더 큰 형태로 출력
		System.out.println(275.0 / 3);// 더 큰 형태로 출력
		System.out.println(275.0 / 3.0);// 더 큰 형태로 출력

		int x = (int) 3.0;// 괄호&값 앞에
		System.out.println(x);// 3
		System.out.println(x + 1);// 3
		System.out.println(x + 1.0);// 3
	}

}
