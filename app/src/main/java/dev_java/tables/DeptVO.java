package dev_java.tables;

public class DeptVO extends Object { // Object -> 따로 명시되어있지 않아도 상속을 받고있는 상태.
  private int deptno;
  private String dname;
  private String loc;

  public int getDeptno() {
    return this.deptno;
  }

  public void setDeptno(int deptno) {
    this.deptno = deptno;
  }

  public String getDname() {
    return this.dname;
  }

  public void setDname(String dname) {
    this.dname = dname;
  }

  public String getLoc() {
    return this.loc;
  }

  public void setLoc(String loc) {
    this.loc = loc;
  }

}
