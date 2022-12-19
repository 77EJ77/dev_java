package dev_java.tables;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DeptTable7 extends JFrame implements ActionListener {
  // 선언부
  // 파라미터의 this는 DeptTable7타입이고 main에서 호출된 생성자로 현재 메모리에 로딩중인 그 객체를 가리킨다.
  // 왜 this를 넘겨야 하나요? 입력할건데...
  // :JTable7Dialog에서 부서번호, 부서명, 지역을 입력한 후 저장버튼을 누르면
  // :Vector<String[]>추가하고 추가된 로우를 포함하는 Vector가 부모창에 새로 리프레쉬(재사용되어야 함 - 이건 부모클래스에
  // 구현함)되어야 하니까... 호출해야함.
  String header[] = { "부서번호", "부서명", "지역" };
  String datas[][] = new String[0][3];
  // rhis는 사용되는 클래스 영역에서 선언된 클래스를 가리킨다.
  // 그러면 여기서는 DeptTable1타입인 것임
  // 그런데 DefaultTableModel은 자바에서 제공되는 클래스임 - 생성자도 정해져있음
  // 생성자는 메소드 오버로딩 규칙을 따름 - 파라미터의 갯수나 타입이 달라야 함
  // 제공되는 생성자에
  JTable7d j7d = new JTable7d(this);
  DefaultTableModel dtm_dept = new DefaultTableModel(datas, header);// 생성자 호출
  JTable jt = new JTable(dtm_dept);
  JScrollPane jsp_dept = new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  JPanel jp = new JPanel();
  JButton j1 = new JButton("조회");
  JButton j2 = new JButton("입력");
  JButton j3 = new JButton("수정");
  JButton j5 = new JButton("상세보기");
  JButton j4 = new JButton("삭제");
  static Vector<String[]> vdata = new Vector<>();// vdata.size() = 0

  // 부서 목록 조회에 들어갈 샘플 데이터 생성
  String[][] depts = {
      { "10", "아이스크림먹는부", "서울" },
      { "20", "잠자는부", "인천" },
      { "30", "드라마보는부", "부산" }
  };

  // 생성자
  public DeptTable7() {
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
    j5.addActionListener(this);
    jp.add(j1);
    jp.add(j2);
    jp.add(j3);
    jp.add(j5);
    jp.add(j4);
    this.add("Center", jsp_dept);
    this.add("North", jp);
    this.setSize(400, 500);
    this.setTitle("부서관리 시스템 Ver 1.0");
    this.setVisible(true);
  }

  // 새로고침 - Vector에 담긴 String[]출력하기
  // 입력, 수정화면에서 저장버튼 누르면 Vector에 String[]추가하고
  // 그 다이얼로그 화면은 닫히고 부모창은 새로고침 처리한다.
  // 그러니까 다이얼로그창에서 부모클래스의 refreshData메소드를 호출해야함
  // 그러니까 인스턴스화 할 때 파라미터에 this를 넘겨서 사용할 수 있도록 할 것(NullPointerException)
  public void refreshData() {
    System.out.println("refreshData 호출");
    if (dtm_dept.getRowCount() == 0) {
      JOptionPane.showMessageDialog(this, "조회 결과가 없습니다", "WARN", JOptionPane.WARNING_MESSAGE);
      return;// refreshData()탈출
    }
    // 입력, 수정 전에 조회된 정보는 삭제함
    while (dtm_dept.getRowCount() > 0) {
      dtm_dept.removeRow(0);
    }
    // 벡터의 크기만큼 반복하면서 dtm_dept 데이터셋에 String[] 추가함
    for (int i = 0; i < vdata.size(); i++) {
      String[] oneRow = vdata.get(i);
      dtm_dept.addRow(oneRow);
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == j1) {// 조회
      // dtm_dept.setDataVector(depts, header);
      refreshData();
    } else if (obj == j2) { // 입력
      // 다이얼로그.set(제목, 활성화여부, 데이터로우값-String[]);
      j7d.set("입력", true, null);
    } else if (obj == j3) { // 수정
      // 다이얼로그.set(제목, 활성화여부, 데이터로우값-String[]);
      int index = jt.getSelectedRow();
      System.out.println(index);
      if (index < 0) {
        System.out.println("선택된 데이터가 없습니다.");
        JOptionPane.showMessageDialog(this, "수정할 데이터를 선택하세요.");
        return;
      }
      // String[] oneRow = vdata.get(index);
      String[] oneRow = depts[index];
      j7d.set("수정", true, oneRow);
    } else if (obj == j4) { // 삭제
      int index = jt.getSelectedRow();
      System.out.println(index);
      if (index < 0) {
        System.out.println("선택된 데이터가 없습니다.");
        JOptionPane.showMessageDialog(this, "삭제할 데이터를 선택하세요.");
        return;
      }
      // Integer deptno = Integer.parseInt((String) dtm_dept.getValueAt(index, 0));
      // System.out.println(deptno);
      dtm_dept.removeRow(index);
    } else if (obj == j5) {// 상세보기
      int index = jt.getSelectedRow();
      if (index < 0) {
        System.out.println("선택된 데이터가 없습니다.");
        JOptionPane.showMessageDialog(this, "상세보기할 데이터를 선택하세요.");
        return;
      }
      String[] oneRow = depts[index];
      j7d.set("상세보기", true, oneRow);
    }

  }

  public static void main(String[] args) {
    new DeptTable7();
  }
}
