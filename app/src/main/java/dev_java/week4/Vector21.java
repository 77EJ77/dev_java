package dev_java.week4;

import java.util.Map;
import java.util.Vector;

public class Vector21 {
  public static void main(String[] args) {
    // 2중[outter = ]for문 돌림
    // 끼워넣기 가능, 수정 대한 API제공은 없다. - 클라우드 기반 데이터베이스 제품 이런식...
    Vector<String[]> v = new Vector<>();
    Vector<Map<String, Object>> v3 = new Vector<>();// 실무 사용 패턴~ 완결편
    // String[][] depts = {
    // { "10", "아이스크림먹는부", "서울" },
    // { "20", "잠자는부", "인천" },
    // { "30", "드라마보는부", "부산" }
    // };
    // for (int x = 0; x < depts[0].length; x++) {
    // for (int y = 0; y < depts.length; y++) {

    // }
    // }
    // 크기가 얼마인가요? 0
    // 단일 for문 처리
    Vector<String> v2 = new Vector<>();
  }
}
