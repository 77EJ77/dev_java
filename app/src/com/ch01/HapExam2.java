package app.src.com.ch01;

//A is B이다 -> 상속관계로 처리한다.
//자동차는 소나타이다
//소나타는 자동차이다
public class HapExam2 extends Object {

	public static void main(String[] args) {
		int i1 = 1;
		int i2 = 2;
		int i3 = 3;
		// 변수 하나를 이용해서 1~3까지 출력
		int num = 1;
		System.out.println(num++ + " " + num++ + " " + num);

		for (int i = 1; i <= 3; i++)
			System.out.print(i + " ");
	}

}
