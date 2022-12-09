package dev_java.study_01;

import java.util.Scanner;

public class P1209_1 {
  public void total(String[][] data) {
    int total = 0;
    for (int i = 0; i < data.length; i++) {
      for (int j = 1; j < data[i].length; j++) {
        total += Integer.parseInt(data[i][j]);
      }
      System.out.println(data[i][0] + "의 총점: " + total);
      total = 0;
    }
  }

  public void p_average(String[] subject, String[][] data) {
    int total = 0;
    for (int i = 0; i < data.length; i++) {
      for (int j = 1; j < data[i].length; j++) {
        total += Integer.parseInt(data[i][j]);
      }
      System.out.println(data[i][0] + "의 평균: " + (double) (total / subject.length));
      total = 0;
    }
  }

  public void s_average(String[] subject, String[][] data) {
    int total = 0;
    for (int i = 0; i < data.length; i++) {
      for (int j = 1; j < data[i].length; j++) {
        total += Integer.parseInt(data[j][i]);
      }
      System.out.println(subject[i] + "의 평균: " + (double) (total / data.length));
      total = 0;
    }
  }

  public void grade(String[] subject, String[][] data) {
    int total = 0;
    for (int i = 0; i < data.length; i++) {
      for (int j = 1; j < data[i].length; j++) {
        total += Integer.parseInt(data[i][j]);
      }
      System.out.println(data[i][0] + "의 평균: " + (double) (total / subject.length));
      total = 0;
    }
  }

  public void ppp() {
    int user_input = -1;
    Scanner sc = new Scanner(System.in);

    String[] subject = { "JAVA", "ORACLE", "SPRING" };
    String[][] data = {
        { "이순신", "80", "75", "70" }, { "강감찬", "90", "85", "95" }, { "김춘추", "65", "60", "60" }
    };

    boolean flag = true;

    while (flag) {
      System.out.println("=================================");
      System.out.println("원하시는 작업을 선택하세요.");
      System.out.println("1. 총점");
      System.out.println("2. 인물 평균");
      System.out.println("3. 과목 평균");
      System.out.println("4. 석차");
      System.out.println("5. 나가기");
      System.out.println("=================================");

      try {
        user_input = sc.nextInt();
      } catch (Exception e) {
        sc = new Scanner(System.in);
      }

      switch (user_input) {
        case 1:
          total(data);
          break;
        case 2:
          p_average(subject, data);
          break;
        case 3:
          s_average(subject, data);
          break;
        case 4:
          grade(subject, data);
          break;
        case 5:
          flag = false;
          break;
      }
    }
  }

  public static void main(String[] args) {
    P1209_1 p1 = new P1209_1();
    p1.ppp();
  }
}
