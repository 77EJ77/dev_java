package dev_java1.sungjuk;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextAreaUI2 implements ActionListener {
   // 선언부
   JTextAreaUILogic2 jtaUILogic = new JTextAreaUILogic2(this);
   JFrame jf = new JFrame();
   JTextArea jta = new JTextArea(10, 20);
   JTextField jtf = new JTextField(10);

   public JTextAreaUI2() {
      initDisplay();
   }
   public JTextArea getTextArea(){
      return jta;
   }

   public void initDisplay() {
      jtf.addActionListener(this);
      jta.setBackground(Color.cyan);
      jf.add("Center", jta);
      jf.add("South", jtf);
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jf.setSize(400, 300);
      jf.setVisible(true);
   }

   public static void main(String[] args) {
      new JTextAreaUI2();
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      Object obj = e.getSource();
      if (jtf == obj) {
         String input = jtf.getText();
         jtaUILogic.account(input);
         jtf.setText("");
      }
   }
}
