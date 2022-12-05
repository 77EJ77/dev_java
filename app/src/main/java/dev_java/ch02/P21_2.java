package dev_java.ch02;

public class P21_2 {
  public static void main(String[] args) { // Entry포인트 / 메인스레드(Thread)
    // ->그 클래스에서 가장 먼저 실행된다.
    int i = 1;
    int j = 2;
    // if((i == --j) & (++i <= j)) {
    // 1 == 1
    if ((i != --j) && (++i <= j)) {
      System.out.println("조건을 만족할 때");
      // insert here - i와 j값을 확인할 수 있다 | 없다
    } else {
      System.out.println("조건을 만족하지 않았을 때");
    }
    // insert here -> i는 얼마? j는 얼마일까요?
    System.out.println("i = " + i + ", j = " + j);
  }
}
