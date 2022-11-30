package app.src.com.ch01;

public class A {

	double pi = 3.14;// 전변

	public static void main(String[] args) {
		double pi = 5.1;// 지변
		// insert here - 전역변수 출력해주세요
		A a = new A();
		System.out.println(pi);// 5.1출력됨-이건 전변이 아니잖아
		System.out.println(a.pi);
	}
	// 보통 내안에 있는 건 호출 가능하나 특이하게 static안에 있는 것은
}
