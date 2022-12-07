package dev_java.ch03;

import java.util.Scanner;

public class Nansu1_2 {
  int com = -1;

  public void ranCom() {
    com = (int) (Math.random() * 10); // 10을 곱하는 이유는 구간을 늘리기 위함
  }

  // user변수때문에 변수 my를 삭제하였다.
  // 사용자가 입력한 값을 지변에 담아야 하는 이유에 대해 설명하시오.
  // ==> 게임이 진행되는 동안에 계속 바뀌어야 하니까
  // 또 com변수는 왜 전역변수여야만 하는지에 대해서도 말해보시오.
  // ==> 정답을 맞출 때까지는 값이 유지되어야 하니까
  public String account(int user) {
    String msg = null;

    if (com > user) {// 정답보다 입력한 값이 작니?
      msg = "높여라";
    } else if (com < user) {// 정답보다 입력한 값이 크니?
      msg = "낮춰라";
    } else if (com == user) {
      msg = "정답";
      // return msg:if문에서 해당 메소드를 탈출할 때 return예약어 사용가능함.
      // 반복문에서는 break문 사용.
    }
    return msg;
  }

  public static void main(String[] args) {
    // 실행하자마자 채번하도록 코딩하시오. - 생성자활용
    // 생성자의 역할 - *전역변수의 초기화(제 1역할), 부모클래스 초기화 포함 - 상속
    Nansu1_2 nan2 = new Nansu1_2();
    // 컴퓨터가 채번한 값을 초기화하는 메소드 호출하기
    nan2.ranCom();// 새게임을 누르면 - 재사용성, 정답을 봤니?
    // 컴퓨터가 채번한 숫자를 출력하시오.
    System.out.println("채번한 숫자 ===> " + nan2.com);// 전역변수이기 때문에 인스턴스변수가 필요함.
    // Scanner를 활용하여 사용자가 입력한 값을 받으시오.
    Scanner sc = new Scanner(System.in);
    // 게임 기회는 5회로 제한하시오.
    int chance = 5;
    int user = -1;
    for (; chance > 0; chance--) {
      System.out.println("chance : " + chance);
      System.out.println("0~9까지의 값을 입력ㄱ");
      try {
        user = sc.nextInt();
      } catch (Exception e) {
        sc = new Scanner(System.in);
      }
      String msg = nan2.account(user);
      System.out.println("msg ===> " + msg);
      if (msg.equals("정답")) {
        // 정답을 맞추었을 경우 축하합니다. 라고 말한 뒤
        System.out.println("축하합니다.");
        // 새 게임 진행 여부를 물어보시오.
        System.out.println("새 게임을 진행하시겠습니까?(y/n)");
        String user_n = sc.nextLine();
        if (user_n.equals("y") || user_n.equals("Y")) {
          nan2.ranCom();
          chance = 5;
          System.out.println("새 게임을 시작합니다.");
        } else {
          System.out.println("종료");
        }
      } else {
        if (chance == 0) {
          System.out.println("주어진 기회를 모두 사용하였다. \n 새 게임을 시작하려면~");
          break;
        } else {
          System.out.println(msg);
          // 시도할 때마다 몇번째 기회를 사용하는지 출력하시오.
          System.out.println("기회 : " + (chance - 1) + "번 남음");
        }
      }
    }
    sc.close();// Stream, I/O, network 사용 후 반드시 닫는다.
  }

}
