package dev_java.tables;

import java.util.Arrays;

public class ArrayCopy1 {

  void deepCopy2() {
    int[] org = { 1, 2, 3, 4, 5 };
    int[] cop = Arrays.copyOf(org, 2);
    cop[1] = 5;
    for (int e : org) {
      System.out.println(e);
    }
    for (int e : cop) {
      System.out.println(e);
    }
  }

  void deepCopy() {
    int[] org = { 1, 2, 3 };
    int[] cop = org.clone();
    cop[2] = 5;
    for (int e : org) {
      System.out.println(e);
    }
    for (int e : cop) {
      System.out.println(e);
    }
  }

  public static void main(String[] args) {
    // int[] org = { 1, 2, 3 };
    // int[] cop = org;
    // cop[2] = 5;
    // for (int e : org) {
    // System.out.println(e);
    // }
    // for (int e : cop) {
    // System.out.println(e);
    // }

    ArrayCopy1 ac = new ArrayCopy1();
    ac.deepCopy2();
  }

  /*
   * 배열 복사
   * > 얕은 복사
   * Shallow Copy // 복사된 배열이나 원본 배열이 변경이 될 때 서로 간의 값이 같이 변경된다.
   * 객체의 주소 값만을 복사하는 것 // 여러 객체가 하나의 주소를 참조함.
   * > 깊은 복사
   * 객체의 실제 값을 새로운 객체로 복사하는 것 -> 배열이 두 개가 만들어지는 것.
   * 복사하고나면 각자 바뀜. -> 메모리 측면에서는 비효율적.
   */
}
