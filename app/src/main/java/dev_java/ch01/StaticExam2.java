package dev_java.ch01;
//static은 변수 앞에 메소드 앞에 올 수 있다.

//static이 있으면 정적변수, 정적 메소드라 한다.
//인스턴스화 없이 어디서나 호출할 수 있다.
//non-static에서 호출할 수 있다.

public class StaticExam2 {
  int i;// 전역변수는 초기화를 생략할 수 있다. 그러면 디폴트 값은 0이다.
  static int j;

  public static void main(String[] args) {
    StaticExam1 staex1 = new StaticExam1();
    StaticExam1 staex2 = new StaticExam1();
    StaticExam1 staex3 = new StaticExam1();
    staex1.methodA();
    staex2.i = 5;
    staex3.i = 3;
    System.out.println(staex1.i);// 1
    System.out.println(staex2.i);// 5
    System.out.println(staex3.i);// 1 -> 3
  }
}
