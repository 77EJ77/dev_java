package dev_java.study_01;

import java.util.Scanner;

/**
 * 야구숫자게임을 완성한다는 가정 하에 힌트가 필요하다.
 * 
 * 파라미터에는 유저가 입력한 값이 들어오도록.
 * 반환값은 ex."1스 2볼"
 * 숫자가 존재하고 자리까지 일치하면 스트라이크
 * 숫자가 존재하나 자리가 다르면 볼
 * 
 * 학습목표
 * 초기화의 문제, 전역변수로 할까요? 아니다 지역변수가 맞다. //-> 답은 지역변수!
 * 자리가 같은지 확인하는 것에 배열의 index를 활용하시오.
 */
public class P1206_1 {
  // 만일 여기서 채번한 값을 다른 클래스에서 재사용해야 한다면 그런 상황이면 나는 전역변수(멤버변수)로 결정한다
  int com[] = new int[3];
  int my[] = new int[3];

  // 난수 발생하여 3자리의 서로 다른 숫자로 된 값을 배열에 담기
  public void ranCom() {
    com[0] = (int) (Math.random() * 10);
    do {
      com[1] = (int) (Math.random() * 10);
    } while (com[0] == com[1]);
    // insert here
    do {
      com[2] = (int) (Math.random() * 10);
    } while (com[0] == com[2] || com[1] == com[2]);
    // for (int i : com) {
    // System.out.print(i);
    // }
  }

  public int[] checkNum(int[] comList, int[] userList) {
    int[] result = new int[2];
    int strike = 0;
    int ball = 0;

    for (int i = 0; i < comList.length; i++) {
      for (int j = 0; j < userList.length; j++) {
        if (comList[i] == userList[j]) {
          if (i == j) {
            strike++;
            break;
          } else {
            ball++;
            break;
          }
        }
      }
    }
    result[0] = strike;
    result[1] = ball;
    return result;
  }

  public String account(int[] comNum) {
    // insert here

    return "X스 X볼";
  }

  public static void main(String[] args) {
    P1206_1 nm = new P1206_1();
    // for (int i = 0; i < 10; i++) {
    nm.ranCom();
    System.out.println(nm.com[0] + ", " + nm.com[1] + ", " + nm.com[2]);
    // }
    int[] comNum = nm.com;
    int[] userNum = new int[3];
    Scanner sc = new Scanner(System.in);
    int user_input = sc.nextInt();
    userNum[0] = (int) (user_input / 100);
    userNum[1] = (int) (user_input / 10);
    userNum[2] = (int) (user_input / 100);

  }

}
