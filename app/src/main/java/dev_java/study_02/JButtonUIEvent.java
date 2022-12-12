package dev_java.study_02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonUIEvent implements ActionListener {
  JButtonUI jui = null;

  public JButtonUIEvent(JButtonUI jButtonUI) {
    this.jui = jButtonUI;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == jui.jbtn_south) {
      System.out.println(jui.jbtn_south.getText() + "버튼 클릭");
    }
  }
}
