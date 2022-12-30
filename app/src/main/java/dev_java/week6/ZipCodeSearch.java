package dev_java.week6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import dev_java.util.DBConnectionMgr;

public class ZipCodeSearch {

  Connection con = null; // 인터페이스
  PreparedStatement psmt = null; // 인터페이스
  ResultSet rs = null; // 인터페이스
  DBConnectionMgr mgr = new DBConnectionMgr();

  public Integer[] getZipcode(String dong) {
    System.out.println("getZipCode호출 성공===>" + dong);
    Integer[] zipcodes = null;
    // List<Integer> imsi = new ArrayList<>();
    Vector<Integer> imsi = new Vector<>();// 자바는 생성부의 이름(형태 / 타입)으로 결정됨
    // StringBuilder sql = new StringBuilder();// 퀴리문 작성시에 String 사용하지 않음
    // StringBuilder 사용할 것
    // sql.append("select zipcode from zipcode_t where dong like ?||'%'");
    String sql = "select zipcode from zipcode_t where dong like ?||'%'";
    try {
      con = mgr.getConnection();
      psmt = con.prepareStatement(sql.toString());
      psmt.setString(1, dong);
      rs = psmt.executeQuery();
      while (rs.next()) {
        // System.out.println(rs.getInt("zipcode"));
        int code = rs.getInt("zipcode");
        imsi.add(code);
      }
      zipcodes = new Integer[imsi.size()];
      imsi.copyInto(zipcodes);
      for (int c : zipcodes) {
        System.out.println(c);
      }
    } catch (Exception e) {
      e.printStackTrace(); // 라인번호 출력, 클래스 이름, 이력 등 출력 -> 해커들에게 힌트가 될 수 있음 // 디버깅시 자주 사용하는 메소드
    } finally {
      mgr.freeConnection(con, psmt, rs);// 서버가 먹통이 될 수 있으니 명시적으로 반드시 닫아주자.
    }

    return zipcodes;
  }

  /*
   * public List<Integer> getZipcode(String dong) {
   * List<Integer> zipcode = null;
   * return zipcode;
   * }
   */

  public static void main(String[] args) {
    ZipCodeSearch z = new ZipCodeSearch();
    z.getZipcode("청룡동");
  }
}
