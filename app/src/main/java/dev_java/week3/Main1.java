package dev_java.week3;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main1 {
  Sub1 sub1 = new Sub1(this);
  // 디폴트 생성자 안에서 화면을 그리는 initDisplay가 호출되고 있다.
  // 이 메소드는 화면을 그리는 메소드이다.
  // 화면이 두 개 열린다????????? - 괜찮아? 이래도 되는건가?
  JFrame jf = new JFrame();

  public Main1() { // 인스턴스화만 했을 뿐인데(생성자 호출만 했을 뿐) initDisplay를 호출함으로써 의존성 발생.
    initDisPlay();
  }

  public void initDisPlay() {
    System.out.println("initDisplay호출");
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setTitle("Main1");
    jf.setSize(200, 300);
    jf.setVisible(true);
  };

  public void refresh() {
    System.out.println("refresh() - 나 호출되었어!");
    JOptionPane.showMessageDialog(jf, "새로고침 처리 되었습니다.");
  }

  public static void main(String[] args) {
    // Main m1 = new Main();
    new Main1();// 인스턴스화 - 메모리에 상주됨 - 변수나 메소드를 사용할 수 있는 상태.
    // 그러나 호출이 불가능함.

    // initDisPlay(); // non-static메소드를 static영역에서 호출불가함
    // m1.initDisPlay();
    // new Main1().initDisPlay();
  }
  /**
   * 디폴트 생성자는 생략이 가능하다.
   * 파라미터가 있는 생성자는 생략이 불가하다.
   * 파라미터가 있는 생성자가 하나라도 있으면 디폴트 생성자도 생략 불가하다.
   * 인스턴스화 할 때 생성부의 이름으로 객체가 생성된다.
   * 이 때 파라미터 자리에 인자를 추가할 수 있다. - 여러 개의 생성자를 선언할 수 있다.
   * :메소드 오버로딩 룰
   * :파라미터의 개수가 다르거나 타입이 달라야 한다.
   */
}
