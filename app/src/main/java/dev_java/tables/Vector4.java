package dev_java.tables;

import java.util.Vector;

public class Vector4 {
  public static void main(String[] args) {
    String fruits[] = { "키위", "포도", "사과" };
    Vector<String> vfruit = new Vector<>();
    // vfruit.copyInto(fruits);
    for (int i = 0; i < fruits.length; i++) {
      vfruit.add(i, fruits[i]);
    }
    vfruit.add(1, "토마토");
    vfruit.remove("포도");
    for (int i = 0; i < vfruit.size(); i++) {
      System.out.println(vfruit.get(i));
    }
  }
}
