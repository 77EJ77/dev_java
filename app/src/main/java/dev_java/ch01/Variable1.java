package dev_java.ch01;

public class Variable1 {
  int x;

  // 나는 파라미터가 없는 메소드 입니다. - 꼰대
  // 나는 반환형이 없다.
  void methodA() {
    // 지변은 반드시 초기화를 해야 한다.
    int i;
    i = 1;
    x = i;
    System.out.println("i = " + i);
  }

  public static void main(String[] args) {
    // insert here
    Variable1 va = new Variable1();
    va.methodA();
    System.out.println("x는 :" + va.x);// 인스턴스변수명.변수명 -> 오직 전역변수만 이렇게 쓸 수 있다. non-static
  }
  // static이 적혀있으면 클래스타입.변수명
}
