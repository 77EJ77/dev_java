package dev_java.tables;

import java.util.Vector;

public class Vector5 {
  public static void main(String[] args) {
    String fruits[] = { "키위", "포도", "사과", "토마토", "메론", "파인애플", "바나나", "복숭아" };
    // String mf[] = {"사과", }; -> 이중for문쓰면됨.
    Vector<String> v = new Vector<>();

    for (int i = 0; i < fruits.length; i++) {
      if (fruits[i].equals("사과") || fruits[i].equals("메론") || fruits[i].equals("파인애플") || fruits[i].equals("복숭아")) {
        v.add(fruits[i]);
      }
    }
    System.out.println(v);
  }
}
