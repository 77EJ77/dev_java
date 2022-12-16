package dev_java.tables;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

//JDialog도 디폴트가 BorderLayout - jpc를 중앙배치
public class JTable7d extends JDialog {
  // 선언부
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
    this.setVisible(true);

  }

  // 메인
  public static void main(String[] args) {
    new JTable7d();
  }
}
