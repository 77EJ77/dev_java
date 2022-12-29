package dev_java.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dev_java.util1.DBConnectionMgr;

public class DeptList {

  Connection con = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  DBConnectionMgr mgr = new DBConnectionMgr();

  public void getDeptList() {

  }

  public static void main(String[] args) {
    DeptList deptList = new DeptList();
    deptList.getDeptList();
  }
}
