package dev_java.week3;

public class Sub {
  int j = 1;

  public void methodSub() {

  }

  public static void main(String[] args) {
    Main m1 = new Main();
    for (boolean b : m1.isOk) {
      System.out.println(b);
    }
    System.out.println("================================");
    for (int i = 0; i < m1.isOk.length; i++) {
      System.out.println(m1.isOk[i]);
    }
    System.out.println("================================");
    for (int i = 0; i < m1.isOk2.length; i++) {// 그냥 찍으면 NullPointerException뜸. main의 생성자에서 getIsOk2()를 소환하게 하면 안뜸.
      System.out.println(m1.isOk2[i]);
    }

    System.out.println("================================");
    boolean[] isOk2 = m1.getIsOk2();
    for (boolean b : isOk2) {
      System.out.println(b);
    }
  }

}
