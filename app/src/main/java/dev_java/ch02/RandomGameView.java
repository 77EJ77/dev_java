package dev_java.ch02;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class RandomGameView {
  // 선언부
  JFrame jf_game = new JFrame();
  JPanel jp_east = new JPanel();
  JButton jbtn_new = new JButton("새게임");
  JButton jbtn_dap = new JButton("정답");
  JButton jbtn_clear = new JButton("지우기");
  JButton jbtn_exit = new JButton("종료");

  // 생성자 - 파라미터가 없는 생성자를 디폴트 생성자라고 함. - 생략 가능함.
  RandomGameView() {// 그러나 화면을 그리는 메소드 호출하기 위해서 굳이 선언하였음. public은 자유롭게 추가 가능하나 void를 붙이면 메소드가 되어버림.
    initDisplay();// 내 안에 있는 메소드이므로 인스턴스화 없이도 가능함.
  }

  // 화면 그리기 구현
  public void initDisplay() {
    // 동쪽에 붙일 속지의 레이아웃을 설정함.
    // 메소드의 파라미터로 객체를 생성함 - 왜냐하면 딱 한번만 호출하니까.
    // GridLayout layout = new GridLayout(4, 1);
    jp_east.setLayout(new GridLayout(4, 1)); // 윗줄의 layout을 파라미터로 넣어도 됨. 같은 의미
    jf_game.add("East", jp_east); // ->add 옆에 붙인다는 의미.
    jp_east.add(jbtn_new);
    jp_east.add(jbtn_dap);
    jp_east.add(jbtn_clear);
    jp_east.add(jbtn_exit);
    jf_game.setSize(450, 400);
    jf_game.setVisible(true);
  }

  public static void main(String[] args) {
    new RandomGameView();
  }
}
