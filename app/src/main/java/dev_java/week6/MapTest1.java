package dev_java.week6;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

class S1 {
  int birthday = 1121;
}

class S2 {
  String chocolate = "로아커";
  int price = 3200;
}

class S3 {
  // 3개짜리 클래스 설계
}

public class MapTest1 {
  List<Map<String, Object>> list = null;

  public static void main(String[] args) {
    S1 s1 = new S1();
    System.out.println(s1.birthday);
    Map<String, Object> map = new HashMap<>();
    map.put("s1", s1);
    S1 s2 = (S1) map.get("s1");
    System.out.println(s2.birthday);
    Map<String, String> map1 = new HashMap<>();
    // map1.put("null", s1);

    Map<String, Object> map2 = new Hashtable<>();// hashTable -> 멀티스레드에서 안전함
    S2 s3 = new S2();
    map2.put("s2", s3);
    S2 s4 = (S2) map2.get("s2");
    System.out.println(s4.chocolate + "는 " + s4.price + "원");

    if (s4.chocolate instanceof String)
      System.out.println("문자열입니다.");
    // Deprecated : 하위버전을 위해 남겨둔
    if (new Integer(s4.price) instanceof Integer)
      System.out.println("정수형입니다.");
  }
}
