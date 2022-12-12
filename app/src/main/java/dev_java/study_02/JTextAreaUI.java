package dev_java.study_02;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 상속이 아니라 인터페이스 오버라이드(추상메소드 재정의) - 결합도는 낮고 재사용성을 높여줌 -> 세련됐다.
// 인터페이스는 추상메소드만 가지고 있어서 반드시 구현체 클래스가 필요함.
public class JTextAreaUI implements ActionListener {
   // 선언부
   JTextAreaUILogic jtaUILogic = new JTextAreaUILogic(this); // ->이른 인스턴스화 // 전역변수의 SCOPE?
   // ↓↓인터페이스는 반드시 구현체 클래스가 있어야 한다. 단독으로 인스턴스화 불가함.
   // ↓↓선언부와 생성부의 타입이 다르다 - 그래서 다형성이 가능함 - 폴리모피즘 - 재사용성을 높이고 결합도는 낮춤.
   // ActionListener al = new ActionListener(); // 불가.
   // ActionListener al = new JTextAreaUI();// 이렇게는 가능함.
   JFrame jf = new JFrame();
   JTextArea jta = new JTextArea(10, 20);
   JTextField jtf = new JTextField(10);

   // 생성자도 메소드처럼 호출 가능. -> 인스턴스화 할 때 // 리턴타입이 없음.
   public JTextAreaUI() {// 디폴트 생성자 선언 // 디폴트 생성자는 생략이 가능하다 -> JVM이 대신 해주니까.
      initDisplay();
   }

   // UI를 그려준다. // 이벤트 처리가 필요하다.
   public void initDisplay() {
      // 이벤트 소스와 이벤트 핸들러 클래스 매핑하기(매칭)
      jtf.addActionListener(this); // this - 나 자신 : 이벤트 핸들러 클래스의 주소번지
      // 멀티라인 작성 가능한 컴포넌트 배경색 설정
      jta.setBackground(Color.cyan);
      // JFrame은 디폴트 레이아웃이 BorderLayout이라서 동 서 남 북 중앙 배치 가능
      jf.add("Center", jta);
      jf.add("South", jtf);
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 윈도우 창 x버튼 클릭시 자원 회수함.
      jf.setSize(400, 300);
      jf.setVisible(true); // 화면을 출력함.
   }

   public static void main(String[] args) {// 가장 먼저 호출됨 - entry point임
      new JTextAreaUI();// 생성자 호출되고 그 안에서 화면 그리는 메소드 호출됨
      // 두 번 호출하면 창도 두 개 뜸.
      // new JTextAreaUI();// 생성자 호출되고 그 안에서 화면 그리는 메소드 호출됨
   }

   // 추상 메소드 선언은 인터페이스 안에서 일어남. -> 메소드 호출이 아닌데';'로 끝남. -> 선언만();
   // 결정되지 않았음. ex 같은 내용인데 구현 내용이 달라짐 -> 이런 목적으로 추상메소드를 사용함.
   // 재정의 -> 메소드 오버라이딩
   // 인터페이스는 반드시 구현체 클래스가 있어야 함.
   // 인터페이스 중심으로 코드를 짜는 것은 클래스간의 결합도를 낮추고 재사용성을 높여주는 코딩 방법이다.
   // annotation - 문법 제약을 가짐 = 선언부가 일치해야 함.
   @Override
   public void actionPerformed(ActionEvent e) {// 메소드 오버라이드는 선언부에 손 댈 수 없음.
      // 추상메소드의 파라미터를 통해서 감지된 컴포넌트의 주소번지를 얻어오는 getSource메소드의 소유주임. -> actionEvent클래스가.
      Object obj = e.getSource();
      if (jtf == obj) {
         // JTextField에 입력한 문자열 받기
         String input = jtf.getText();
         jta.append("JTextAreaUI원본 : " + input + "\n");
         jtaUILogic.account(input);
         jtf.setText("");
      }
   }
}
