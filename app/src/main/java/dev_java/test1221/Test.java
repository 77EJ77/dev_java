package dev_java.test1221;

import java.util.Scanner;

//클래스 하나에 기능 하나만..
public class Test {
  public void sum() {
    Scanner sc = new Scanner(System.in);

    System.out.print("1 이상의 숫자를 입력하세요 : ");
    int num = sc.nextInt();

    int sum = 0;
    if (num > 0) {
      int i = 1;
      while (i <= num) {
        sum += i;
        i++;
      }
      System.out.println("1부터 " + num + "까지의 합은 " + sum + "입니다.");
    } else {
      System.out.println("숫자가 1이상이 아닙니다.");
    }
  }

  public static void main(String[] args) {
    Test t = new Test();
    t.sum();
  }
}
