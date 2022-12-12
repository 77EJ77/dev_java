package dev_java.study_02;

// 메모리 StackOverFlow발생 - 서버가 중지됨
public class JTextAreaUILogic {

  JTextAreaUI jtaUI = null;

  public JTextAreaUILogic(JTextAreaUI jTextAreaUI) {
    this.jtaUI = jTextAreaUI;
    // 생성자 안에서 JTextAreaUI의 JTextArea원본과 전역변수를 초기화해줘야 함
  }

  public void account(String input) {
    System.out.println("account 호출 성공");
    // JTextAreaUI클래스에 정의된 주소번지를 사용하고 싶다. 어떡하지?
    // insert here
    jtaUI.jta.append("UILogic : " + input + "\n");
  }

}
