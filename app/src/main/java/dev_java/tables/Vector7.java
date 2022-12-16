package dev_java.tables;

import java.util.Arrays;
import java.util.Vector;

public class Vector7 {
  String[][] list = {
      { "10", "개발부", "서울" },
      { "20", "인사부", "인천" },
      { "30", "총무부", "부산" } };

  public static void main(String[] args) {
    Vector7 v7 = new Vector7();
    DeptVO dvo;
    Vector<DeptVO> v = new Vector<>();

    for (int i = 0; i < v7.list.length; i++) {
      dvo = new DeptVO(Integer.parseInt(v7.list[i][0]), v7.list[i][1], v7.list[i][2]);
      v.add(dvo);
    }
    for (int i = 0; i < v.size(); i++) {
      System.out.print(v.get(i).getDeptno() + " ");
      System.out.print(v.get(i).getDname() + " ");
      System.out.print(v.get(i).getLoc());
      System.out.println();
    }
  }
}
