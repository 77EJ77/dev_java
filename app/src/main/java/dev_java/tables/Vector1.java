package dev_java.tables;

import java.util.Vector;

public class Vector1 {
  public static void main(String[] args) {
    Vector v = new Vector();
    Vector<String> v2 = new Vector<>();// 벡터는 오브젝트 단위로 담을 수 있다. 그 타입을 직관적으로 알 수 있도록 <>사용
    v2.add("안녕");
    v2.add("2");
    Vector<Integer> v3 = new Vector<>();
    Vector<DeptVO> v4 = new Vector<>();// 이런게 가능하기 때문에 -> 3차 배열 안쓴다.
    // v.add(1);
    // v.add(new Integer(1)); <- 선 그어짐. 굳이 왜 쓰냐. 이런 의미.
    v.add("안녕");
    v.add("1");
    System.out.println(v.size()); // 방(Element)의 수 반환
    System.out.println(v.get(0)); // 1
    System.out.println(v.get(1)); // 안녕
    String insa = (String) v.get(0);
    System.out.println(insa);
    String insa2 = v2.get(0);
    System.out.println(insa2);
    if (v.get(1) instanceof Integer) {
      System.out.println("넌 정수형이야.");
    }
    if (v.get(0) instanceof String) {
      System.out.println("넌 문자열이야.");
    }
  }
}
