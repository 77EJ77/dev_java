package dev_java.week3;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//기본 패키지인 java.lang이외에는 모두 import필요함
//인터페이스를 implements하면 반드시 추상메소드를 재정의해야 함 - override

public class Sub1 implements ActionListener { // 선언부↓ 전역변수의 위치. -> 선언에서 결정되는 건 무엇입니까? : 타입만 결정.
  // 원시형은 필드와 메소드를 가질 수 없다.
  // 원시형은 부르면 값이 나온다.
  // 참조형은 부르면 주소가 나온다.
  // 원시형에서는 NullPointerException 있을 수 없음. sub1.insert();
  // Line 9와 Line 10은 다르다.▽
  Main1 main1 = null;// 선언만 했다. -> null의 의미는 : 결정되지 않았다. 모르겠다.
  // Main1 main2 = new Main1();// Line 10는 선언도 했고 생성도 했고 생성자도 호출한다. - 복제본이 만들어짐.

  JDialog jdg = new JDialog();
  JButton jb = new JButton("저장");

  public Sub1(Main1 main1) { // -> Main1 main1 == null 의미됨.
    System.out.println(main1);
    if (main1 == null)
      System.out.println("main1은 null입니다. 객체 생성 안 된 상태임");
    this.main1 = main1;// 객체 치환

    // 나는 언제 호출되나요? - 메인 앱이 실행될 때
    // 나는 어디서 호출되나요? - Main1클래스에서
    // 나는 왜 호출하는 거죠? - 입력 눌렀을 때, 주문을 할 때, 회원가입을 할 때
    initDisPlay();
  }

  public void initDisPlay() {
    jb.addActionListener(this);
    jdg.add("South", jb);
    jdg.setTitle("Sub1");
    jdg.setSize(300, 400);
    jdg.setVisible(true);
  }

  int insert() {
    // main1 사용 불가하다. -> 지변이니까. -> 어떻게 할까? 전역변수로 받아서 사용! -> Line 17
    int result = 0;
    result = 1;
    return result;
  }

  // public static void main(String[] args) {
  // new Sub1(null); // -> Line 23
  // }

  /********************************************************************************
   * 콜백 메소드라고 부른다.
   * 저장 버튼이 클릭되었을 때 JVM이 이를 감지하고 인터셉트하여 메소드 호출을 해줌
   * 파라미터인 ActionEvent객체를 통해서 이벤트가 감지된 버튼을 구분할 수 있음.
   * 이 객체는 파라미터에 있으므로 JVM으로부터 주입이 되는 객체이다.
   * 다시말해 개발자가 인스턴스화 하지 않고 JVM이 대신 해줌
   ********************************************************************************/
  @Override
  public void actionPerformed(ActionEvent e) {
    Object ob = e.getSource();
    // 반복문을 탈출할 때는 break문을 사용하고
    // 조건문을 탈출할 때는 return을 사용함 -> 메소드를 빠져나가는 것임.
    if (ob == jb) {
      int result = insert();
      if (result == 1) {
        JOptionPane.showMessageDialog(jdg, "입력 성공하였습니다.");
        jdg.dispose();
        main1.refresh();
      } else {
        JOptionPane.showMessageDialog(jdg, "입력 실패하였습니다.");
        return; // actionPerformed를 탈출함.
      }
    }
  }
}
