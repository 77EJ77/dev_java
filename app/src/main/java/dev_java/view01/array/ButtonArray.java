package dev_java.view01.array;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;//java가 들어가는 건 윈도우에서 가져다 쓰는 것.

import javax.swing.JButton;//javax는 자바에서 제공하는 게 맞음.
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ButtonArray implements ActionListener {
  // 선언부
  JFrame jf = new JFrame();// setSize(400, 300); 가로세로크기지정 setVisible(true);윈도우창에 활성화하기
  JPanel jp_center = new JPanel();
  JTextArea jta_display = new JTextArea(10, 20);
  JScrollPane jsp_display = new JScrollPane(jta_display);
  JTextField jtf_input = new JTextField();
  JPanel jp_east = new JPanel();
  JButton jbtn_new = new JButton("새 게임");
  JButton jbtn_dap = new JButton("정답");
  JButton jbtn_clear = new JButton("지우기");
  JButton jbtn_exit = new JButton("나가기");

  // 생성자
  public ButtonArray() {
    System.out.println("디폴트 생성자 호출");
    // 이벤트 소스와 이벤트처리를 담당하는 핸들러클래스를 매핑하기.
    jtf_input.addActionListener(this);// this -> 추상메소드 // JVM이 구현체 클래스이구나 생각한다는 의미라는데 모르겠..
    jbtn_new.addActionListener(this);
    jbtn_dap.addActionListener(this);
    jbtn_clear.addActionListener(this);
    jbtn_exit.addActionListener(this);
    initDisplay();
  }

  // 화면 그리기
  public void initDisplay() {
    System.out.println("화면 그리기 호출");
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 창이 꺼지면 프로그램 종료.
    jp_center.setLayout(new BorderLayout());
    jp_center.add("Center", jsp_display);
    jp_center.add("South", jtf_input);
    jp_east.setLayout(new GridLayout(4, 1, 2, 2));
    jbtn_new.setBackground(new Color(255, 255, 255));
    jbtn_new.setForeground(new Color(000, 000, 000));
    jbtn_dap.setBackground(new Color(255, 255, 255));
    jbtn_dap.setForeground(new Color(000, 000, 000));
    jbtn_clear.setBackground(new Color(255, 255, 255));
    jbtn_clear.setForeground(new Color(000, 000, 000));
    jbtn_exit.setBackground(new Color(255, 255, 255));
    jbtn_exit.setForeground(new Color(000, 000, 000));
    jp_east.add(jbtn_new);
    jp_east.add(jbtn_dap);
    jp_east.add(jbtn_clear);
    jp_east.add(jbtn_exit);
    jp_center.setBackground(Color.lightGray);
    jf.add("Center", jp_center);
    jf.add("East", jp_east);
    jf.setSize(400, 300);
    jf.setVisible(true);
  }

  // 메인메소드
  public static void main(String[] args) {
    new ButtonArray();
  }

  @Override
  public void actionPerformed(ActionEvent e) {// 콜백메소드
    // TODO Auto-generated method stub
    // 이벤트처리하는 3단계
    // 1. 이벤트소스가 어떤 이벤트 리스너인지 찾아내야함.
    // 2. 재정의
    // 3.
    // 너 JTextField에서 엔터친거야?
    Object obj = e.getSource(); // e.getSource는 이벤트가 감지되는 컴포넌트(JTextField)의 주소번지를 반환함.
    if (jtf_input == obj) { // 같다는 건 감지가 되었다는 것. 눌렸다는 의미.
      // setText하지 않고 append로 처리 -> 덧붙이기 위해.
      // 사용자가 텍스트 필드에 입력한 문자열을 읽어옴.
      String input = jtf_input.getText();
      jta_display.append(input + "\n");
      jtf_input.setText("");
    } else if (jbtn_new == obj) {// 새 게임 하려고? // 주소번지를 비교하는 것이기 때문에 equals쓰면 XXXX
      jta_display.append("~(´･ω･`)?새 게임을 시작합니다~\n");
    } else if (jbtn_dap == obj) {// 정답 볼래?
      jta_display.append("＼（〇_ｏ）／정답은 ???입니다.\n");
    } else if (jbtn_clear == obj) {// 화면 좀 지워줘
      jta_display.setText("");
    } else if (jbtn_exit == obj) {// 그만할래
      // jf.dispose();// 창 하나씩 따로 닫을 때는 dispose
      System.exit(0);// 몽땅 한 번에 닫을 때
    }
  }
}
