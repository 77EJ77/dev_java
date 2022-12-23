package dev_java.network1;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Graphics;
import java.awt.Font;

public class LoginForm extends JFrame {
  String imgPath = "D:\\vscode_java\\dev_java\\images\\login\\";
  ImageIcon ii = new ImageIcon(imgPath + "main.png");
  JLabel lid = new JLabel("ID");
  JTextField tid = new JTextField("");
  JLabel lpw = new JLabel("PW");
  JPasswordField tpw = new JPasswordField();
  Font font = new Font("나눔고딕", Font.BOLD, 17);
  JButton jblog = new JButton(new ImageIcon(imgPath + "login.png"));
  JButton jbjoi = new JButton(new ImageIcon(imgPath + "confirm.png"));

  LoginForm() {
    // initDisplay();
  }

  // 내부 클래스로 배경이미지 처리
  class MyPanel extends JPanel {
    public void paintComponent(Graphics g) {
      g.drawImage(ii.getImage(), 0, 0, null);
      setOpaque(false);
      super.paintComponent(g);
    }
  }// end of MyPanel - 사용자 패널 정의 - LoginForm$1.class, LoginForm$MyPanel.class

  public void initDisplay() {
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setContentPane(new MyPanel());
    this.setLayout(null);
    lid.setBounds(45, 200, 80, 40);
    lid.setFont(font);
    tid.setBounds(110, 200, 185, 40);
    this.add(lid);
    this.add(tid);
    lpw.setBounds(45, 240, 80, 40);
    lpw.setFont(font);
    tpw.setBounds(110, 240, 185, 40);
    this.add(lpw);
    this.add(tpw);
    jbjoi.setBounds(45, 285, 120, 40);
    this.add(jbjoi);
    jblog.setBounds(175, 285, 120, 40);
    this.add(jblog);
    this.setTitle("자바채팅 Ver1.0");
    this.setLocation(500, 100);
    this.setSize(350, 600);
    this.setVisible(true);
  }

  public static void main(String[] args) {
    LoginForm lf = new LoginForm();
    lf.initDisplay();
  }
}
