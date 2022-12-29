package dev_java.oracle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 회원정보 담기
public class MapTest3 {

  public static void main(String[] args) {
    List<Map<String, Object>> list = new ArrayList<>();
    // 회원아이디, 회원이름, 회원비번, 성별
    // mem_id, mem_name, mem_pw, mem_gender
    // home, 가고파, gogogo, other
    // burger, 마이너스, soso, 비밀
    // coffee, 쿠폰, good, 굿
    Map<String, Object> map = new HashMap<>();
    System.out.println(list);
    map.put("mem_id", "home");
    System.out.println(map); // @abcd1234
    System.out.println(map.toString()); // @abcd1234
    map.put("mem_name", "가고파");
    map.put("mem_pw", "gogogo");
    map.put("mem_gender", "other");
    list.add(map);
    map = new HashMap<>();
    map.put("mem_id", "burger");
    map.put("mem_name", "마이너스");
    map.put("mem_pw", "soso");
    map.put("mem_gender", "비밀");
    list.add(map);
    map = new HashMap<>();
    map.put("mem_id", "coffee");
    map.put("mem_name", "쿠폰");
    map.put("mem_pw", "good");
    map.put("mem_gender", "굿");
    list.add(map);
    System.out.println(list);

    // List<Map<>> - 밖에 있는 List는 대괄호로 묶음
    // 제네릭은 {}좌중괄호 우중괄호로 묶음
  }
}
