package dev_java.oracle;

import java.util.HashMap;
import java.util.Map;

public class MapTest5 {
  public static void main(String[] args) {
    Map<String, Object> map = new HashMap<>();
    map.put("mem_id", "home");
    System.out.println(map); // @abcd1234
    System.out.println(map.toString()); // @abcd1234
    map.put("mem_name", "가고파");
    map.put("mem_pw", "gogogo");
    map.put("mem_gender", "other");
  }
}
