package dev_java.study_01;

import java.util.Scanner;

public class P1212_1 {
  /**
   * 연습문제 1
   * 다음은 타원의 면적을 구하는 공식입니다. 작은 반지름과 큰 반지름을 입력받아서 타원의 면적을 구하세요.
   * 반지름은 정수이고, pi는 3.1416입니다.
   * 계산은 소수점 2자리 까지 합니다.
   * 공식) 타원면적 = pi * r1 * r2
   * 출력) 반지름(2개) : 10 20
   * 타원의 면적 : 628.32
   * 
   * 연습문제 2
   * 두 개의 정수 중에서 큰 숫자를 반환하는 max함수를 구현하세요. 두 개의 정수를 입력 받고 큰 숫자를 출력합니다.
   * 
   * 출력) 정수(두 개) : 5 8 최대값 : 8
   * 
   * 연습문제 3
   * 달의 중력은 지구 중력의 17%에 불과합니다. 지구에서 몸무게가 100kg인 사람은 달에 가면 17kg밖에 안됩니다. 당신의
   * 몸무게는 달에서 얼마입니까? 몸무게 N은 실수이고 키보드로부터 입력받습니다.
   * 출력) 지구몸무게 : 100 달 몸무게 : 17kg
   * 
   * 연습문제 4
   * 두숫자를 입력 받아 둘 사이의 3의 배수 갯수를 카운트 하는 프로그램을 작성하시오.
   * 예) 3, 13 두 숫자를 입력하였다면 3개 출력해 줌
   */
  public static void main(String[] args) {

  }

  public void p1212() {
    boolean flag = true;
    Scanner sc = new Scanner(System.in);
    int choice = 0;
    while (flag) {
      System.out.println("====================");
      System.out.println("1. 연습문제1");
      System.out.println("2. 연습문제2");
      System.out.println("3. 연습문제3");
      System.out.println("4. 연습문제4");
      System.out.println("====================");
      System.out.print("번호를 입력하세요 : ");
      try {
        choice = sc.nextInt();
      } catch (Exception e) {
        sc = new Scanner(System.in);
      }
      switch (choice) {
        case 1:
          num1();
          break;
        case 2:
          num2();
          break;
        case 3:
          num3();
          break;
        case 4:
          num4();
          break;
        default:
          System.out.println("잘못 입력하셨습니다.");
      }
    }
  }

  public void num1() {

  }

  public void num2() {

  }

  public void num3() {

  }

  public void num4() {

  }
}
