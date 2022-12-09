package dev_java.view01.array;

public class AccountSample {
  ButtonArray_copy bc = null;

  public AccountSample(ButtonArray_copy bc) {
    this.bc = bc;
  }

  public String account() {
    return "낮춰라";
  }

  public void account2() {
    String msg = "낮춰라";
    bc.jta_display.append(msg + "\n");
  }
}
