package dev_java.week4;

import java.util.ArrayList;
//자바에서 제공하는 자료구조는 java.util폴더에 있음
import java.util.List;
import java.util.Vector;

public class List1 {
  public static void main(String[] args) {
    // 아래는 생성부에 인터페이스가 와서 에러임 - 구현체 클래스
    // List<String> nameList = new List<>();
    // 왜 벡터인가요? - DefaultTableModel객체에 데이터셋을 추가하는 메소드를 제공하니까..
    List<String> nameList2 = new Vector<>();// 멀티스레드에 안전하다. - 속도 느림 - (경합이 벌어져도) 안전하다.
    // List<String> nameList3 = new ArrayList<>();// 싱글스레드에 안전하다. - 속도 빠름 - 안전하지 않다.
    System.out.println(nameList2.size());// 0
    boolean isOk = nameList2.add("관악정");
    System.out.println();
    System.out.println();
  }
}
