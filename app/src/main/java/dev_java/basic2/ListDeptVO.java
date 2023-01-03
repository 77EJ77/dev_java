package dev_java.basic2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dev_java.tables.DeptVO;
import dev_java.util.DBConnectionMgr;

public class ListDeptVO {

  DBConnectionMgr mgr = new DBConnectionMgr();
  Connection con = null;// 오라클 서버와 연결통로 확보
  PreparedStatement pst = null;// 전령역할 -> 자바에서 오라클 서버로 DML전달
  ResultSet rs = null;// 커서 컨트롤 -> 오라클 테이블에 제공되는 커서를 조작하는 함수 제공

  public List<DeptVO> getEmpList() {
    List<DeptVO> list = null;
    StringBuilder sql = new StringBuilder();// String -> 원본이 바뀌지 않기 때문에 String으로 하면 망함
    sql.append("SELECT empno, ename, dname FROM emp, dept WHERE emp.deptno=dept.deptno");

    try {
      con = mgr.getConnection();
      pst = con.prepareStatement(sql.toString());// StringBuilder -> String으로 맞춰주기
      rs = pst.executeQuery();
      list = new ArrayList<>();// list.size -> 0
      DeptVO dv = null;
      while (rs.next()) {
        dv = new DeptVO();// 디폴트 생성자 호출 -> 값이 0, null, null
        dv.setDeptno(Integer.parseInt(rs.getString("empno")));
        dv.setDname(rs.getString("dname"));
        dv.setLoc(rs.getString("ename"));
        list.add(dv);// 0부터 차례대로 들어감
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

  public static void main(String[] args) {
    ListDeptVO ldv = new ListDeptVO();
    List<DeptVO> list = null;
    list = ldv.getEmpList();
    System.out.println("list: " + list);
    for (DeptVO dv : list) {
      System.out.println(dv);// while문을 타지 않으면 null인 상태
      System.out.println(dv.getDeptno() + ", " + dv.getDname() + ", " + dv.getLoc());
    }
  }
}
