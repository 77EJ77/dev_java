package dev_java.week3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JFrameRepaint extends JFrame implements ActionListener {

  JPanel jp = new JPanel();
  JTextArea ja = new JTextArea("ja", 10, 20);
  JButton jb = new JButton("화면 변경");

  public JFrameRepaint() {
    initDisplay();
  }

  public void initDisplay() {// 컴포넌트 단위로 리프레시가 안 됨. 그래서 패널을 깔고 그 패널을 통으로 바꾸는 방법을 사용함.
    jb.addActionListener(this);
    jp.setLayout(new BorderLayout());
    jp.add("Center", ja);
    this.add("Center", jp);
    this.add("North", jb);
    this.setSize(400, 300);
    this.setVisible(true);
  }

  public static void main(String[] args) {
    new JFrameRepaint();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object ob = e.getSource();
    if (ob == jb) {// 주소번지 비교
      Container con = this.getContentPane();
      if (jp != null) {
        con.remove(jp);
      }
      JPanel jp1 = new JPanel();
      jp1.setBackground(Color.DARK_GRAY);
      this.add("Center", jp1);// 메모리 관리가 개발자 책임이 아닌 JVM의 책임이라 같은 이름을 써도 될지 모름. 그래서 변수명 다르게 설정해줬다.
      con.revalidate();
    }
  }// end of actionPerformed
}// end of JFrameRepaint
