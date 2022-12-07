package dev_java.ch03;

//java 예외처리
//java finally 사용법 //mdn -> js //API보는 방법에 익숙해지도록 연습해야.
public class Finally1 {
  public static void main(String[] args) {
    int i = 10;
    int j = 2;
    j = 0;
    j = 5;
    try {
      System.out.println(i / j);
    } catch (ArithmeticException e) {
      System.out.println(e.getMessage());
    } finally {// 무조건 실행하려는 것을 넣음.
      System.out.println("finally는 무조건 실행이 된다.");// 연산의 결과와 상관없이 정상이거나 에러거나
    }
  }

}
