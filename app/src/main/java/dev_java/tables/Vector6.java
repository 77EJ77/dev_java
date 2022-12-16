package dev_java.tables;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Vector6 {
  public static void main(String[] args) {
    String[][] list = {
        { "부서번호", "부서명", "지역" },
        { "10", "개발부", "서울" },
        { "20", "인사부", "인천" },
        { "30", "총무부", "부산" } };
    Vector<String[]> v = new Vector<>();
    for (int i = 0; i < list.length; i++) {
      v.add(list[i]);
    }
    // System.out.println(Arrays.toString(v.get(0)));

    Scanner s = new Scanner(System.in);
    System.out.print("삭제할 인덱스 : ");
    int i = s.nextInt();
    v.remove(i);
    for (String[] ss : v) {
      System.out.println(Arrays.toString(ss));
    }
    s.close();
  }
}
