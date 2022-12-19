package dev_java.tables;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//JDialog도 디폴트가 BorderLayout - jpc를 중앙배치
public class JTable7d extends JDialog implements ActionListener {
  // 선언부
  DeptTable7 dt7 = null;
  String[] oneRow = null;
  JPanel jpc = new JPanel();
  JScrollPane jsp = new JScrollPane(); // 지금은 예쁘라고 붙임
  JPanel jps = new JPanel(); // ->저장 / 닫기 용
  JLabel jl1 = new JLabel("부서번호");
  JTextField jf1 = new JTextField(10);
  JLabel jl2 = new JLabel("부서명");
  JTextField jf2 = new JTextField(20);
  JLabel jl3 = new JLabel("지역");
  JTextField jf3 = new JTextField(20);
  // jps속지
  JButton jb1 = new JButton("저장");
  JButton jb2 = new JButton("닫기");

  // 생성자
  public JTable7d() {
  }

  public JTable7d(DeptTable7 deptTable7) {
    dt7 = deptTable7;
    initD();
  }

  // 화면 그리기
  public void initD() {
    this.setSize(500, 360);
    jpc.setLayout(null);
    jps.setLayout(new FlowLayout(FlowLayout.RIGHT));
    jl1.setBounds(20, 20, 50, 20);
    jf1.setBounds(70, 20, 100, 20);
    jl2.setBounds(170, 20, 40, 20);
    jf2.setBounds(210, 20, 100, 20);
    jl3.setBounds(310, 20, 30, 20);
    jf3.setBounds(340, 20, 100, 20);
    jb1.addActionListener(this);
    jb2.addActionListener(this);
    jpc.add(jl1);
    jpc.add(jl2);
    jpc.add(jl3);
    jpc.add(jf1);
    jpc.add(jf2);
    jpc.add(jf3);
    jps.add(jb1);
    jps.add(jb2);
    jsp.add(jpc);
    this.add("Center", jpc);
    this.add("South", jps);
    this.setVisible(false);

  }

  // 각 컬럼(부서 집합 - 부서번호, 부서명, 지역)의 값을 설정하거나 읽어오는 getter/setter메소드임
  public void setDeptNum(String deptno) {
    jf1.setText(deptno);
  }

  public void setDeptName(String deptname) {
    jf2.setText(deptname);
  }

  public void setDeptLoc(String deptloc) {
    jf3.setText(deptloc);
  }

  public String getDeptNum() {
    return jf1.getText();
  }

  public String getDeptName() {
    return jf2.getText();
  }

  public String getDeptLoc() {
    return jf3.getText();
  }

  // 아래 메소드는 DeptTable7에서 호출됨
  // actionPerformed에서 이벤트(입력, 수정, 상세보기)가 발생되면 호출됨
  public void set(String title, boolean isView, String[] oneRow) {
    this.setTitle(title);
    this.setVisible(isView);
    this.oneRow = oneRow;
    setValue(oneRow);
  }

  public void setValue(String[] oneRow) {
    // 입력을 위한 윈도우 설정 - 모든 값을 빈문자열로 셋팅함
    if (oneRow == null) {
      setDeptNum("");
      setDeptName("");
      setDeptLoc("");
      // 상세조회, 수정시는 배열로 받은 값으로 세팅함
    } else {
      setDeptNum(oneRow[0]);
      setDeptName(oneRow[1]);
      setDeptLoc(oneRow[2]);
    }
  }// end of setValue

  // 메인
  public static void main(String[] args) {
    new JTable7d(null);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object ob = e.getSource();
    if (ob == jb1) {
      // oneRow가 존재하면 수정모드, 그렇지 않으면 입력모드로 함
      if (oneRow != null) {

      } else {
        String[] oneRow = { getDeptNum(), getDeptName(), getDeptLoc() };
        dt7.vdata.add(oneRow);
        dt7.refreshData();
        this.dispose();
      }
    } else if (ob == jb2) {
      this.dispose();
    }
  }
}
