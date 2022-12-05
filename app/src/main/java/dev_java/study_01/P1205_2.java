package dev_java.study_01;

import java.util.Random;
import java.util.Scanner;

public class P1205_2 {
  /**
   * 0부터 9사이의 임의의 수를 채번하고 그 숫자를 맞추는 게임을 구현하시오.
   * 기회는 단 5번 -> 실패하면 [바보] 출력하고 끝.
   * java.util.random
   * Random r = new Random();
   * 힌트는 낮춰라, 높여라
   * 맞으면 축하합니다. 끝.
   */
  public static void main(String[] args) {
    P1205_2 p2 = new P1205_2();
    p2.gameS();
  }

  public void gameS() {
    int count = 0;
    int count_de = 10;
    Random r = new Random();
    int result = r.nextInt(99);// 괄호안에 10을 적으면 0.0~10.0까지
    Scanner sc = new Scanner(System.in);
    System.out.println("☆★즐거운 숫자 맞추기 게임☆★");
    for (; count < count_de; count++) {
      System.out.print("[목숨 : " + (count_de - count) + "/" + count_de + "] 숫자를 입력하세요: ");
      try {
        int user_input = sc.nextInt();
        if (result == user_input)
          break;
        else if (count != (count_de - 1) && result < user_input)
          System.out.println("낮춰라.");
        else if (count != (count_de - 1) && result > user_input)
          System.out.println("높여라.");
      } catch (Exception e) {
        sc = new Scanner(System.in);
      }
    }
    if (count >= count_de)
      System.out.println("넌 바보");
    else
      System.out.println("축하합니다.");
  }
  // System.exit(0); -> 강제종료//연결고리 끊음.
}
