package dev_java.view01;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomGameDemo implements ActionListener {
  // 선언부
  // JFrame jf = null;
  JFrame jf = new JFrame();
  JButton jbtn_north = new JButton("북쪽");// 생성자 파라미터는 String
  JButton jbtn_south = new JButton("남쪽");// 생성자 파라미터는 String
  JButton jbtn_east = new JButton("동쪽");// 생성자 파라미터는 String
  JButton jbtn_west = new JButton("서쪽");// 생성자 파라미터는 String
  JButton jbtn_center = new JButton("중앙");// 생성자 파라미터는 String

  // 생성자
  public RandomGameDemo() {// 인스턴스화 하면 생성자 호출이 동시에 일어난다. 그래서 클래스 이름과 생성자 이름은 맞춰주어야함.
    System.out.println("디폴트 생성자 호출 성공");
    initDisplay();
  }

  // 화면처리부
  public void initDisplay() {
    // jf = new JFrame();
    System.out.println("initDisplay 호출");
    jbtn_north.addActionListener(this);
    jbtn_south.addActionListener(this);
    jbtn_east.addActionListener(this);
    jbtn_west.addActionListener(this);
    jbtn_center.addActionListener(this);
    jf.add("North", jbtn_north);
    jf.add("South", jbtn_south);
    jf.add("East", jbtn_east);
    jf.add("West", jbtn_west);
    jf.add("Center", jbtn_center);
    jf.setSize(300, 300);
    jf.setVisible(true);
  }

  // UI API를 활용하여 공부를 하면
  // 1. 초기화를 활용할 수 있게 됨
  // 2. 생성자 역할에 대해 알게 됨
  // 3. 사용자 정의 메소드를 많이 만들어 볼 수 있음
  // 4. 파라미터와 리턴타입에 대해 확실해짐.
  // 5. 전역변수와 지역변수를 구분하여 코딩을 전개하게 됨
  // 6. 클래스를 나누는 조건을 갖게 됨
  // 7. 이벤트 처리를 사전학습할 수 있음
  // 8. 익명클래스를 활용할 수 있음 - 익명함수, arrow function 등 신 문법을 공부하는데 도움됨

  // 메인메소드
  public static void main(String[] args) {
    new RandomGameView();
    // 선언부없이 생성자만 호출할 수 있다. 인스턴스변수를 재사용할 일이 없다면 괜찮아
    // new RandomGameView();// 복제본이 생성됨. 그러나 서로 다른 객체임.
    // new RandomGameView();// 마찬가지. 타입은 동일 그러나 다른 객체???

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println(e.getActionCommand());
    System.out.println(e.getSource());
    String label = e.getActionCommand();
    if (label.equals("중앙")) {
      System.out.println(label + " 클릭");
    } else if (label.equals("동쪽")) {
      System.out.println(label + " 클릭");
    }
  }
}
