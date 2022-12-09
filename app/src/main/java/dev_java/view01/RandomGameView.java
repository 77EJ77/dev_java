package dev_java.view01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RandomGameView implements ActionListener/* , FocusListener */ {
  // 선언부
  JFrame jf = new JFrame();
  // 남쪽에 붙임
  JTextField jtf_input = new JTextField(5);// 생성자 파라미터는 int
  // 중앙에 붙임
  JTextArea jta_display = new JTextArea(10, 20);// 생성자 파라미터는 int 2개
  JScrollPane scrollPane = new JScrollPane(jta_display, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

  // 생성자
  public RandomGameView() {
    System.out.println("디폴트 생성자 호출 성공");
    initDisplay();
  }

  // 화면처리부
  public void initDisplay() {
    // jf = new JFrame();
    System.out.println("initDisplay 호출");
    jtf_input.requestFocus();
    jtf_input.addActionListener(this);
    jta_display.setEditable(false);
    jf.add("South", jtf_input);
    jf.add("Center", scrollPane);
    jf.setSize(300, 400);
    jf.setVisible(true);
  }

  // 메인메소드
  public static void main(String[] args) {
    new RandomGameView();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // 엔터의 주소번지를 가져온다.
    Object obj = e.getSource();
    if (jtf_input == obj) {
      System.out.println("사용자가 입력한 값은 " + jtf_input.getText());
      jta_display.append(jtf_input.getText() + "\n");
      jta_display.setCaretPosition(jta_display.getDocument().getLength());
      jtf_input.setText("");// 지우기는 더블퀘테이션으로 대체
    }
  }
}
