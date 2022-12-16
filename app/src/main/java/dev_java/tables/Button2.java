package dev_java.tables;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Button2 extends JFrame {
  // 선언부
  String jbtn_label[] = { "입력", "수정", "삭제" };
  JPanel jp_north = new JPanel();
  Vector<JButton> v = new Vector<>(jbtn_label.length);
  // JButton jbtn_ins = new JButton(jbtn_label[0]);
  // JButton jbtn_upd = new JButton(jbtn_label[1]);
  // JButton jbtn_del = new JButton(jbtn_label[2]);
  // JButton[] jb = { jbtn_ins, jbtn_upd, jbtn_del };

  // 생성자
  public Button2() {
    initDisplay();
  }

  // 화면그리기
  public void initDisplay() {
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    for (int i = 0; i < jbtn_label.length; i++) {
      v.add(new JButton(jbtn_label[i]));
      jp_north.add((JButton) v.get(i));
    }
    this.add("North", jp_north);
    this.setSize(400, 500);
    this.setVisible(true);
  }

  // 메인메소드
  public static void main(String[] args) {
    new Button2();
  }
}
