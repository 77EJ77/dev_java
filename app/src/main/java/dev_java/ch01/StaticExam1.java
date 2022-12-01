package dev_java.ch01;
//static은 변수 앞에 메소드 앞에 올 수 있다.

//static이 있으면 정적변수, 정적 메소드라 한다.
//인스턴스화 없이 어디서나 호출할 수 있다.
//non-static에서 호출할 수 있다.

public class StaticExam1 {
  int i;// 전역변수는 초기화를 생략할 수 있다. 그러면 디폴트 값은 0이다.
  static int j;

  void methodA() {
    i = i + 1;// 1
    j = i * 2;// 2
    System.out.println("i : " + i);
    System.out.println("j : " + StaticExam1.j); // 생략해도 되나 붙여주는게 표준
  }

  public static void main(String[] args) {
    StaticExam1 staex1 = new StaticExam1();
    staex1.methodA();
  }
}
