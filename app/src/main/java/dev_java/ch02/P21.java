package dev_java.ch02;

public class P21 {
  public void print() {
    System.out.println("i의 초기값 = 1");
    System.out.println();

    int i = 1;// i=1
    int j = ++i;// 대입이 먼저냐, 더하기가 먼저냐 // 2, 1
    System.out.println("j = ++i -> " + j);
    System.out.println("i = " + i);
    System.out.println();

    i = 1;
    j = i++;
    System.out.println("j = i++ -> " + j);
    System.out.println("i = " + i);
    System.out.println();

    i = 1;
    j = --i;
    System.out.println("j = --i -> " + j);
    System.out.println("i = " + i);
    System.out.println();

    i = 1;
    j = i--;
    System.out.println("j = i-- -> " + j);
    System.out.println("i = " + i);
  }
}
