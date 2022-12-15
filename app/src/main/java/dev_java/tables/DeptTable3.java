package dev_java.tables;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.*;

// 이른 인스턴스화, 게으른 인스턴스화
// 어떤 클래스를 상속 받을 때에는 extends 예약어를 사용
// A is a B관계이면 상속으로 처리한다.
// 1. 소나타는 자동차이다. <-정답!
// 2. 자동차는 소나타이다.
// 부모클래스가 가진 변수와 메소드도 사용가능함 - 자손이 더 많이 누릴 수 있다.
// ActionListener - 인터페이스 - 단독으로 인스턴스화가 불가함 - 구현체 클래스가 필요함
// 추상메소드를 선언하고 있다.
// ActionListener al = new DeptTable3(); -> 선언부와 생성부가 다를 수 있다. - 이럴 때만 다형성이 가능함.
// 선언부와 생성부가 다르다. - 동일한 메소드를 호출했는데 다른 기능이 처리되었다???? -> 다형성의 컨셉
// 추상클래스도 구현체 클래스가 필요하다. - this
// Duck myDuck = new WoodDuck(); myDuck.fly();
// Duck herDuck = new RubberDuck(); herDuck.fly();
// Duck himDuck = new MallardDuck(); himDuck.fly(); -> 뒤에 어떤 객체가 오느냐에 따라서 기능이 달라질 수 있다는 것.
public class DeptTable3 extends JFrame implements ActionListener { // DeptTable1 is a JFrame
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
  JButton j1 = new JButton("조회");
  JButton j2 = new JButton("입력");
  JButton j3 = new JButton("수정");
  JButton j4 = new JButton("삭제");

  // 부서 목록 조회에 들어갈 샘플 데이터 생성
  String[][] depts = {
      { "10", "아이스크림먹는부", "서울" },
      { "20", "잠자는부", "인천" },
      { "30", "드라마보는부", "부산" }
  };

  // 생성자
  public DeptTable3() {
    initDisplay();
  }

  // 화면그리기
  public void initDisplay() {
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jp.setLayout(new FlowLayout(FlowLayout.LEFT));
    j1.addActionListener(this);
    j2.addActionListener(this);
    j3.addActionListener(this);
    j4.addActionListener(this);
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
    new DeptTable3();
  }

  public void setData(String[][] data) {
    dtm_dept.setDataVector(data, header);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == j1) {// 조회버튼 누른거야?
      // 단순 출력.
      // for (int i = 0; i < depts.length; i++) {
      // for (int j = 0; j < depts[i].length; j++) {
      // // System.out.print(depts[i][j] + "\t");
      // System.out.print(dtm_dept.getValueAt(i, j));
      // if ((j + 1) == depts.length)
      // System.out.println();
      // }
      // }
      // for (int i = 0; i < depts.length; i++) {
      // Vector<String> oneRow = new Vector<>();
      // for (int j = 0; j < depts[i].length; j++) {
      // oneRow.add(depts[i][j]);
      // }
      // dtm_dept.addRow(oneRow);
      // }
      setData(depts);
    } else if (obj == j2) { // 입력

    } else if (obj == j3) { // 수정

    } else if (obj == j4) { // 삭제
      int index = jt.getSelectedRow();
      System.out.println(index);
      Integer deptno = Integer.parseInt((String) dtm_dept.getValueAt(index, 0));
      System.out.println(deptno);

      // dtm_dept.setNumRows(0);
      // String[][] sample = new String[3][3];

      // for (int i = 0; i < depts.length; i++) {
      // sample[i] = depts[i].clone();
      // }
      // setData(sample);
      dtm_dept.removeRow(index);
    }
  }
}
