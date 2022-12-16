package dev_java.tables;

import java.util.Vector;

public class Vector6_1 {
  Vector<String[]> v = new Vector<>();

  String[][] list = {
      { "부서번호", "부서명", "지역", "010-8989-1212" },
      { "10", "개발부", "서울" },
      { "20", "인사부", "인천" },
      { "30", "총무부", "부산" } };

  void initVector() {
    for (int i = 0; i < list.length; i++) {
      v.add(list[i]);// 벡터에 담기는 것은 1차배열임 - 컬럼의 수는 바뀔 수 있음 - 4
    }
  }

  void initVectorPrint() {
    for (int i = 0; i < v.size(); i++) {
      String[] oneRow = v.get(i);
      System.out.println(oneRow.toString());
      for (int j = 0; j < oneRow.length; j++) {
        System.out.print(oneRow[j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Vector6_1 v6 = new Vector6_1();
    // initVector메소드를 경유하지 않았기 때문에 size는 0이다.
    v6.initVector();
    // v.get(0) -> {"부서번호", "부서명", "지역"}
    // v.get(1) -> {"10", "개발부", "서울"}
    // v.get(2) -> {"20", "인사부", "인천"}
    // v.get(3) -> {"30", "총무부", "부산"}
    System.out.println(v6.v.size()); // 0 -> 3
    v6.initVectorPrint();
  }
}
