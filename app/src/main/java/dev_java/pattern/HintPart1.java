package dev_java.pattern;

import java.util.Scanner;

public class HintPart1 {
  // 선언부
  // 컴퓨터가 채번한 숫자를 담을 1차 배열 선언
  int com[] = new int[3];
  // 사용자가 입력한 문자열 쪼개서 담을 1차 배열 선언
  int user[] = new int[3];
  // 회차를 담을 변수 선언
  int cnt;

  // 새 게임 버튼을 누르면 3자리의 서로 다른 숫자를 채번한다.
  public void ranCom() {
    com[0] = (int) (Math.random() * 10);
    // 중복된 숫자를 제거하는 목적으로 do-while선택.
    do {
      com[1] = (int) (Math.random() * 10);
    } while (com[0] == com[1]);
    do {
      com[2] = (int) (Math.random() * 10);
    } while (com[0] == com[2] || com[1] == com[2]);
  }

  // 3자리 숫자를 입력 받아서 힌트문을 작성해주는 메소드 구현
  public String checkNum(String user_input) {
    String result = null;
    int strike = 0;
    int ball = 0;

    if (user_input.length() != 3) {
      return "세자리 숫자만 입력하세요."; // checkNum 탈출하기
    }

    int imsi = 0;// 파라미터로 넘어온 사용자가 입력한 문자열 값을 정수형으로 변환 담기

    try {
      imsi = Integer.parseInt(user_input);
    } catch (NumberFormatException e) {
      return "숫자만 입력하세요.";
    }
    user[0] = imsi / 100; // 256/100 -> 2.56 -> 2만 남음
    user[1] = (imsi % 100) * 10; // 256%100 -> 56/10 -> 5.6 -> 5만 남음
    user[2] = imsi % 10; // 256%10 -> 몫은 25이고 나머지는 6이다.

    for (int i = 0; i < com.length; i++) {// 입력받은 숫자가 com배열에 존재하니? 네-볼, 아니오-제외
      for (int j = 0; j < user.length; j++) {// 만일 위에서 네라면 스트라이크인지 검사란다 com배열의 i자리와 user배열의 j자리가 같은지 비교
        if (com[i] == user[j]) {// 같은 숫자가 있는지만 비교하고 자리가 달라도 참이다.
          // 볼은 확보되었다. 자리가 같은지 비교하자.
          // 숫자의 자리도 같아?
          if (i == j)// 자리까지 같은지 비교
            strike++;
          else
            ball++;
        }
      }
    }
    if (strike == 3)
      return "정답입니다.";

    result = strike + "S " + ball + "B";
    return result;
  }

  public static void main(String[] args) {
    HintPart1 hp = new HintPart1();
    hp.ranCom();
    Scanner sc = new Scanner(System.in);
    String user_input = null;
    String result = "";
    hp.cnt = 1;
    while (hp.cnt < 6) {
      System.out.println("3자리 숫자를 입력하세요.");
      user_input = sc.nextLine();
      result = hp.checkNum(user_input);
      hp.cnt++;
      System.out.println(result);
      if (result.equals("정답입니다.")) {
        System.out.println("게임끝");
      }
      if (hp.cnt == 6) {
        System.out.println("당신의 기회는 끝났다.");
        System.out.println(hp.com[0] + "" + hp.com[1] + "" + hp.com[2]);
      }
    }
  }
}
