package dev_java.view01;

import java.util.Random;
import java.util.Scanner;

public class RandomGameLogic {
  /**
   * 0부터 9사이의 임의의 수를 채번하고 그 숫자를 맞추는 게임을 구현하시오.
   * 기회는 단 5번 -> 실패하면 [바보] 출력하고 끝.
   * java.util.random
   * Random r = new Random();
   * 힌트는 낮춰라, 높여라
   * 맞으면 축하합니다. 끝.
   */
  public String gameS() {
    int count = 0;
    int count_de = 10;
    String result_msg = null;
    // 랜덤하게 채번하는 메소드를 제공하는 클래스 선언 및 생성하기.
    Random r = new Random();// new 다음에 오는 이름의 객체가 로딩 -> 생성자 호출도 일어남.
    // (참조형의) 클래스 선언은(초기화를 하지 않은 선언은) 생성자를 호출하지 않는다.
    // =(대입연산자) new 클래스이름 () -> 이게 있을 경우에만 생성자가 호출되는 것이다.
    // 사용자로부터 입력받는 장치를 생성자의 파라미터에 적어준다. 메소드처럼 생성자도 파라미터를 가질 수 있다.
    int result = r.nextInt(99);// 괄호안에 10을 적으면 0~10까지 인데 10미만.
    // Scanner 클래스를 사용하면 입력장치로 입력된 정보를 받아올 수 있다. -> 듣기.
    // 생성자의 파라미터에 입력장치에 대한 코드가 필요함.
    // System -> 내가 사용하는 컴퓨터의 장치.
    // 그 뒤에 변수 in을 붙이면 입력장치를 나타냄.
    // System.out.println("☆★즐거운 숫자 맞추기 게임☆★");
    for (; count < count_de; count++) {
      System.out.print("[목숨 : " + (count_de - count) + "/" + count_de + "] 0~99까지의 숫자를 입력하세요: ");
      // try {
      // nextInt메소드는 Scanner클래스가 소유주이다.
      // int user_input = sc.nextInt();
      // if (result == user_input)// 맞다 - 변수가 가리키는 값이 같은지를 비교하는 것임 - 원시형 변수이다. -직접접근방식
      // break;
      // else if (count != (count_de - 1) && result < user_input)
      // System.out.println("낮춰라.");
      // else if (count != (count_de - 1) && result > user_input)
      // System.out.println("높여라.");
      // } catch (Exception e) {
      // sc = new Scanner(System.in);
      // }
    }
    // sc.close();// 사용한 Scanner의 주소번지는 반드시 닫아줌. - 왜냐하면 위변조를 막기 위해서.
    if (count >= count_de)
      System.out.println("넌 바보");
    else
      System.out.println("축하합니다.");
  }
  // System.exit(0); //-> 강제종료//연결고리 끊음.
  // 파라미터에 0을 주면 자바가상머신과의 연결고리 끊김 -> 종료 -> 할당된 스레드 반환됨

}
