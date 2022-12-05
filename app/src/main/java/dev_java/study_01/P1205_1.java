package dev_java.study_01;

import java.util.Scanner;

public class P1205_1 {
  public static void main(String[] args) {
    P1205_1 p1205 = new P1205_1();
    p1205.mma();
  }

  /**
   * 초기 실행용~~
   */
  public void mma() {
    boolean con = true;
    Scanner sc = new Scanner(System.in);
    while (con) {
      first_print_out();
      System.out.print("입력값 : ");
      int result = 0;
      try {
        result = sc.nextInt();
      } catch (Exception e) {
        sc = new Scanner(System.in);
      }
      switch (result) {
        case 1:
          moon1(10);
          break;
        case 2:
          moon2(10);
          break;
        case 3:
          moon3(100);
          break;
        case 4:
          con = false;
          System.out.println("종료합니다.");
          break;
        default:
          System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
      }
    }
    sc.close();

  }

  /**
   * 1~num까지의 합
   */
  public void moon1(int num) {
    int sum = 0;
    for (int i = 1; i <= num; i++) {
      sum += i;
    }
    System.out.println("1 ~ " + num + "까지의 합 = " + sum);
  }

  /**
   * 1~num까지 세면서 짝수의 합
   */
  public void moon2(int num) {
    int sum = 0;
    for (int i = 1; i <= num; i++) {
      System.out.println(i);
      if (i % 2 == 0)
        sum += i;
    }
    System.out.println("1 ~ " + num + "까지의 짝수의 합 = " + sum);
  }

  /**
   * fizzbuzz
   */
  public void moon3(int num) {
    for (int i = 1; i < 101; i++) {
      if (i % 5 == 0 && i % 7 == 0)
        System.out.println("fizzbuzz");
      else if (i % 5 == 0)
        System.out.println("fizz");
      else if (i % 7 == 0)
        System.out.println("buzz");
      else
        System.out.println(i);
    }
  }

  /**
   * 실행가능 목록 출력
   */
  public void first_print_out() {
    System.out.println("===== 22/12/05 과제목록 =====");
    System.out.println("===== 1. 1~10 합계 출력 =====");
    System.out.println("===== 2. 짝수 합계 출력 =====");
    System.out.println("===== 3. fizzbuzz       =====");
    System.out.println("===== 4. 종료           =====");
  }
}
