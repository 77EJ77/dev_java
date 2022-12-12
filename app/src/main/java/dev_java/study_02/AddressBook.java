package dev_java.study_02;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressBook implements ActionListener {
  // 선언부
  JFrame jf = new JFrame();
  JPanel jp = new JPanel();
  String[] jb_label = new String[] { "조회", "입력", "수정", "상세보기" };
  JButton[] jbtn = new JButton[4];
  JTable jt = new JTable();
  AddressDialog aDialog = new AddressDialog();

  // 생성자
  public AddressBook() {
    initDisPlay();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    System.out.println(obj);
    System.out.println(jbtn[0]);
    if (obj == jbtn[0]) {
      System.out.println("찍히나");
      aDialog.jdg.setVisible(true);
    }
  }

  public void initDisPlay() {
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setSize(500, 450);
    jf.setTitle("주소록 Ver1.0");
    jp.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
    for (int i = 0; i < jbtn.length; i++) {
      jbtn[i] = new JButton(jb_label[i]);
      jp.add(jbtn[i]);
    }
    jf.add("North", jp);
    jf.add("South", jt);
    jf.setVisible(true);
  }

  public static void main(String[] args) {
    new AddressBook();
  }
}
