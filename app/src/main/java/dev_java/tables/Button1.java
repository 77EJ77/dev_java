package dev_java.tables;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Button1 extends JFrame {
  // 선언부
  String jbtn_label[] = { "입력", "수정", "삭제" };
  JPanel jp_north = new JPanel();
  JButton[] jb = new JButton[3];
  // JButton jbtn_ins = new JButton(jbtn_label[0]);
  // JButton jbtn_upd = new JButton(jbtn_label[1]);
  // JButton jbtn_del = new JButton(jbtn_label[2]);

  // 생성자
  public Button1() {
    initDisplay();
  }

  // 화면그리기
  public void initDisplay() {
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    for (int i = 0; i < jb.length; i++) {
      jb[i] = new JButton(jbtn_label[i]);
      jp_north.add(jb[i]);
    }
    // jp_north.add(jbtn_ins);
    // jp_north.add(jbtn_upd);
    // jp_north.add(jbtn_del);
    this.add("North", jp_north);
    this.setSize(400, 500);
    this.setVisible(true);
  }

  // 메인메소드
  public static void main(String[] args) {
    new Button1();
  }
}
