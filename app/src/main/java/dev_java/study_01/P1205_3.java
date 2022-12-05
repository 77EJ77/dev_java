package dev_java.study_01;

public class P1205_3 {
  /**
   * 2022/12/05 숙제
   * 피보나치 수열의 규칙을 만족하는 프로그램을 작성하고
   * a1에서 a10번째 항까지 출력되도록 해보시오.
   * hint : 치환, 변수선언, 초기화
   */
  public static void main(String[] args) {
    P1205_3 p3 = new P1205_3();
    p3.print();
  }

  public void print() {
    int num1 = 1;
    int num2 = 1;
    int count = 10;
    for (int i = 0; i < count; i++) {
      num2 += num1;

      System.out.println("a" + i + ": " + num2);
    }
  }
}
