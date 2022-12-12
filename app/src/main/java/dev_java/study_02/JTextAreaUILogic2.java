package dev_java.study_02;

public class JTextAreaUILogic2 {
  JTextAreaUI2 jTextAreaUI2 = null;

  public JTextAreaUILogic2(JTextAreaUI2 jTextAreaUI2) {
    this.jTextAreaUI2 = jTextAreaUI2;
  }

  public void account(String input) {
    jTextAreaUI2.jta.append(input + "\n");
  }
}
