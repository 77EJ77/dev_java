package dev_java.tables;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

// 이른 인스턴스화, 게으른 인스턴스화
// 어떤 클래스를 상속 받을 때에는 extends 예약어를 사용
// A is a B관계이면 상속으로 처리한다.
// 1. 소나타는 자동차이다. <-정답!
// 2. 자동차는 소나타이다.
// 부모클래스가 가진 변수와 메소드도 사용가능함 - 자손이 더 많이 누릴 수 있다.
public class DeptTable1 extends JFrame { // DeptTable1 is a JFrame
  // 선언부
  String header[] = { "부서번호", "부서명", "지역" };
  String datas[][] = new String[1][3];
  // this는 사용되는 클래스 영역에서 선언된 클래스를 가리킨다.
  // 그러면 여기서는 DeptTable1타입인 것임
  // 그런데 DefaultTableModel은 자바에서 제공되는 클래스임 - 생성자도 정해져 있음
  // 생성자는 메소드 오버로딩 규칙을 따름 - 파라미터의 갯수나 타입이 달라야 함
  // 제공되는 생성자에 없음 - 결국 사용 못함 - 컴파일 에러(문법 에러 발생)
  DefaultTableModel dtm_dept = new DefaultTableModel(datas, header);// 생성자 호출
  JTable jt = new JTable(dtm_dept);
  JScrollPane jsp_dept = new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  JPanel jp = new JPanel();
  JButton j1 = new JButton("입력");
  JButton j2 = new JButton("수정");
  JButton j3 = new JButton("삭제");
  JButton j4 = new JButton("상세보기?");

  // 생성자
  public DeptTable1() {
    initDisplay();
  }

  // 화면그리기
  public void initDisplay() {
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jp.setLayout(new FlowLayout(FlowLayout.LEFT));
    jp.add(j1);
    jp.add(j2);
    jp.add(j3);
    jp.add(j4);
    this.add("Center", jsp_dept);
    this.add("North", jp);
    this.setSize(400, 500);
    this.setTitle("부서관리 시스템 Ver 1.0");
    this.setVisible(true);
  }

  // 메인메소드
  public static void main(String[] args) {
    new DeptTable1();
  }
}
