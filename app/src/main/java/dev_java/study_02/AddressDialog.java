package dev_java.study_02;

import javax.swing.JDialog;

public class AddressDialog {
  JDialog jdg = new JDialog();

  public AddressDialog() {
    jdg.setTitle("");// 입력/수정/상세보기
    jdg.setSize(400, 300);
    jdg.setVisible(false);
  }

  public static void main(String[] args) {
    new AddressDialog();
  }

}
