package dev_java.oracle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapTest2 {
  List<Map<String, Object>> list = new ArrayList<>();
  Map<String, Object> rMap = new HashMap<>();// rMap.size() = 0

  public void setMap() {
    rMap.put("deptno", 10);
    rMap.put("dname", "인사부");
    rMap.put("loc", "서울");
    list.add(rMap);// list.get(0);
    rMap = new HashMap<>();
    rMap.put("deptno", 20);
    rMap.put("dname", "개발부");
    rMap.put("loc", "부산");
    list.add(rMap);// list.get(1);
    rMap = new HashMap<>();
    rMap.put("deptno", 30);
    rMap.put("dname", "총무부");
    rMap.put("loc", "제주");
    list.add(rMap);// list.get(2);
  }

  public void mapPrint() {
    // 각 로우안에 key가 세개 있다.(컬럼-deptno, dname, loc)
    // Map m1 = get(0), Map m2 = get(1), Map m3 = get(2)
    // 아래에서 반복해야하는 건 List이다(ArrayList이다)
    for (int i = 0; i < list.size(); i++) {// 반복해서 처리할 값은 로우값임 get(0), get(1), get(2)
      Map<String, Object> m = list.get(i);
      // 컬럼의 수를 반복해서 출력하기
      Object[] keys = m.keySet().toArray();
      for (int j = 0; j < keys.length; j++) {
        String key = (String) keys[j];
        System.out.println(m.get(key));
      }
    }
  }

  public static void main(String[] args) {
    MapTest2 mt = new MapTest2();
    // Map의 size는 세로방향이다. 컬럼의 수이다
    System.out.println(mt.rMap.size());
    Set<String> set = mt.rMap.keySet();
    Iterator<String> iter = set.iterator();
    while (iter.hasNext()) {

    }
  }
}
