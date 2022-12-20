package dev_java.week4;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class List2 {
  public static void main(String[] args) {
    // 자료구조를 지원하는 클래스들은 오브젝트의 존재유무 체크
    // 포함여부
    // 비어있는지, 채워져있는지 확인할 수 있는 api를 제공하고 있음.
    List<String> fruitList = new Vector<>();
    fruitList.add("샤인머스켓");
    fruitList.add("망고");
    boolean isExist = fruitList.contains("골드키위");
    isExist = fruitList.contains("망고");
    if (isExist) {
      System.out.println("들어있다.");
    } else {
      System.out.println("없다");
    }
    boolean isEmpty = fruitList.isEmpty();
    System.out.println(isEmpty);// false
    // Vector나 ArrayList는 오브젝트 추가, 꺼내는 기능 제공
    // Iterator는 그 안에 오브젝트 존재유무 -> 관심사가 다름.
    Iterator<String> iter = fruitList.iterator();
    while (iter.hasNext()) {
      String fname = iter.next();
      System.out.println(fname);
    }
    Iterator iter2 = fruitList.iterator();
    while (iter2.hasNext()) {
      // 다이아몬드 연산자의 의미임 - 타입을 명시적으로 작성함
      String fname = iter2.next();// 제네릭 타입을 지정하지 않아서 에러
      System.out.println(fname);
    }
    // 아래와 같이 사용할 수 없다.
    // 왜냐하면 Vector의 제네릭 타입이 String이니까
    Iterator<Object> iter3 = fruitList.iterator();// 불법
    Iterator<String> iter4 = fruitList.iterator();// 합법
  }
}
