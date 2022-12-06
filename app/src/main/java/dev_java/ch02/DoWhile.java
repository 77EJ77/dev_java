package dev_java.ch02;

public class DoWhile {

  public static void main(String[] args) {
    int i = 1;
    while (i > 3) {
      System.out.println("while 실행문 출력");
    }
    // 굳이 i값을 1로 초기화한 것은 동일한 조건에서 테스트하기 위함.
    System.out.println("빠져나옴.");
    i = 1;
    do {
      System.out.println("do-while 실행문 출력");

    } while (i > 3);
  }

}
