package dev_java.ch03;

public class Q54 {
  public void testIfA() {
    if (testIfB("true")) {
      System.out.println("True");
    } else {
      System.out.println("Not True");
    }
  }

  public boolean testIfB(String str) {
    return Boolean.valueOf(str);// Boolean의 API
  }

  public static void main(String[] args) {
    Q54 q = new Q54();
    q.testIfA();
  }
}
