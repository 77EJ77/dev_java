package dev_java.ch02;

public class P21_1 {
  public static void main(String[] args) {
    P21 sc = new P21();
    sc.print();
    int i = 1;
    switch (i) {// 조건에 따라 실행할 수 있는 포맷 제공 // 챗봇/채팅/메신저 등에서는 swtich문을 사용하는게 직관적임.
      case 0:
        ++i;// 실행문
      case 1:
        ++i;// 실행문 2
        // 만약에 break있다면↓
        break;// switch 탈출
      default:
        ++i;// 실행문 3
    }// end of switch
     // insert here - i는 얼마일까요?
    System.out.println();
    System.out.println("i = " + i);
  }// 코드의 양은 늘어나더라도 복잡도가 늘어나선 안된다.
   // 반복되는 코드는 줄여야한다.
   // 초등학생 6학년이 보더라도 이해할 수 있을 레벨의 코드.
}
