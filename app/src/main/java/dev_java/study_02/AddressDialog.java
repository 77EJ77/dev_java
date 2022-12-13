package dev_java.study_02;

import javax.swing.JDialog;

public class AddressDialog {
  JDialog jdg = new JDialog();

  public AddressDialog() {
    initDisPlay();
  }

  public void initDisPlay() {
    jdg.setSize(400, 300);
    jdg.setVisible(false);

  }

  public void setDialog(String title, boolean isView) {
    jdg.setTitle(title);
    jdg.setVisible(isView);
  }
}
