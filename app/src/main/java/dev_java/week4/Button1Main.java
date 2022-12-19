package dev_java.week4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class Button1 extends JFrame {
  // 선언부
  Button1Event bevent = new Button1Event(this);// 상속, 추상클래스 중심, 인터페이스 중심 코딩 전개
  // 게으른 인스턴스화
  JButton jbtn_ins = null;// 선언만 했다. 생성자 호출 안됨.
  // 이른 인스턴스화
  JButton jbtn_upd = new JButton("수정");// 선언 및 생성 동시에 생성자 호출까지 일어남

  // 생성자
  Button1() {
    System.out.println("Button1 디폴트 생성자 호출");
    // 생성자 안에서 버튼 객체를 생성하면 뭐가 다르지? 어떻게 다른걸까? - 시점에 따라 NullPointerException이 발생 가능
    initDisplay();
    System.out.println("initDisplay 호출 후 : " + (jbtn_ins == null));
    jbtn_ins = new JButton("입력");
    System.out.println("입력버튼 생성 후 : " + (jbtn_ins == null));
  }

  // 화면처리부
  public void initDisplay() {
    // jbtn_upd.addActionListener(this);//이러면 망함. 액션 퍼폼드X
    jbtn_upd.addActionListener(bevent);
    System.out.println("initDisplay 호출 성공");
    // 동쪽 배치
    JButton jbtn_del = new JButton("삭제");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.add("North", jbtn_ins);
    this.add("South", jbtn_upd);
    this.add("East", jbtn_del);
    this.setSize(400, 300);
    this.setVisible(true);
  }
}

class Button1Event implements ActionListener {

  Button1 b1 = null;

  public Button1Event(Button1 button1) {
    b1 = button1;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object ob = e.getSource();
    if (ob == b1.jbtn_ins) {

    }

  }

}

public class Button1Main {
  public static void main(String[] args) {
    Button1 b1 = new Button1();
    Button1 b2 = new Button1();
    Button1 b3 = new Button1();

  }
}
