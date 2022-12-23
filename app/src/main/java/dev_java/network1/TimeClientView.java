package dev_java.network1;

import javax.swing.JLabel;

import javax.swing.JFrame;
import java.awt.Font;

public class TimeClientView extends JFrame {
  // 선언부
  JLabel timer = new JLabel("현재시간", JLabel.CENTER);
  Font f = new Font("나눔고딕", Font.BOLD, 46);

  // 생성자
  TimeClientView() {
    initDisplay();
  }

  // 화면처리부
  public void initDisplay() {
    Thread th = new TimeClient(timer);
    th.start();
    timer.setFont(f);
    this.add("Center", timer);
    this.setSize(400, 300);
    this.setVisible(true);
  }

  // 메인메소드
  public static void main(String[] args) {
    new TimeClientView();
  }
}
