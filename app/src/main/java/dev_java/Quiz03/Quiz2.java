package dev_java.Quiz03;

/**
 * 연습문제 2
 * -10에서 10사이의 정수 10개를 랜덤하게 채번하여 음수와 양수의 합계를 구하는 프로그램을 작성하시오.
 * 변수는 몇 개 필요할까요? 2개 mhap = 0, phap = 0
 * 
 * 전변으로 해야하는 변수는 무엇일까요?
 * 배열 int nansus[] = new int[10];
 * 
 * 메소드 선언하기
 * void setArray()
 * void setArray(int size)
 * 
 * 
 * void total(){
 * }
 * 
 * 난수 수집체크
 * void nansuPrint(){
 * }
 * 
 * 출력)
 * 배열 : 9 -2 -3 8 0 -3 -8 -6 -2 0
 * 음수합 : -24
 * 양수합 : 17
 */
public class Quiz2 {
  int users[] = null;
  int mhap = 0, phap = 0;

  void setArray() {
    users = new int[10];
    for (int i = 0; i < users.length; i++) {
      users[i] = (int) (Math.random() * 21) % 22 - 10;
    }
  }

  void setArray(int size) {
    users = new int[size];
    for (int i = 0; i < users.length; i++) {
      // 0.0~1.0 실수형
      users[i] = (int) (Math.random() * 21) % 22 - 10;
    }
  }

  void total() {
    for (int i = 0; i < users.length; i++) {
      if (users[i] < 0)
        mhap += users[i];
      else
        phap += users[i];
    }
    System.out.println("음수 합 : " + mhap);
    System.out.println("양수 합 : " + phap);
  }

  // 난수 수집 체크
  void nansuPrint() {
    System.out.print("배열 : ");
    for (int i = 0; i < users.length; i++) {
      System.out.print(users[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Quiz2 q2 = new Quiz2();
    q2.setArray();
    q2.nansuPrint();
    q2.total();
  }
}
