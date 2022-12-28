package dev_java.week5;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

//List-java.util.List(interface) - ArrayList, Vector임
//결론 - 그래서(그런 이유로) m메소드가 m2메소드보다 더 좋다.
public class MyB {
  void m(List<String> myNames) {
    System.out.println("***********List************");
    for (String s : myNames) {
      System.out.println(s);
    }
  }

  void m2(Vector<String> myNames) {
    System.out.println("************Vector***********");
    for (String s : myNames) {
      System.out.println(s);
    }
  }

  // 인터페이스
  // 1. 단독으로 인스턴스화할 수 없음
  // 2. 추상메소드로 이뤄져있음
  // 3. 구현체클래스로 만들어서 사용
  // 4. 결합도를 낮춰주는 코드를 전개할 수 있게 해줌

  // JVM에서 제공하는 List에 대해서 구현체 클래스가 여러가지 있다
  // 선언부와 생성부의 타입이 서로 다를 수 있다 - 권장사항
  // 권장하는 이유는 2가지 선택지가 있다
  public static void main(String[] args) {
    MyB mb = new MyB();
    List<String> nickNames3 = new Vector<>();
    nickNames3.add("3");
    nickNames3.add("4");
    nickNames3.add("5");
    ArrayList<String> nickNames = new ArrayList<>();
    nickNames.add("0");
    nickNames.add("1");
    nickNames.add("2");
    Vector<String> nickNames2 = new Vector<>();
    nickNames2.add("3");
    nickNames2.add("4");
    nickNames2.add("5");
    mb.m(nickNames);
    mb.m(nickNames2);
    mb.m(nickNames3);
    // mb.m2(nickNames);
    mb.m2(nickNames2);
    // mb.m2(nickNames3);
  }
}
