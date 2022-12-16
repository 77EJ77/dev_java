package dev_java.tables;

class T1 {
  int i = 1;
}

public class T1Main {
  public static void main(String[] args) {
    T1 t1 = new T1();
    System.out.println(t1);
    t1 = new T1();
    System.out.println(t1);
    t1 = new T1();
    System.out.println(t1);
    T1[] t1s = new T1[3];
    for (T1 t : t1s) {
      System.out.print(t + " ");
    }
  }
}
