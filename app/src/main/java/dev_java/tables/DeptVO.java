package dev_java.tables;

import lombok.Builder;
import lombok.Data;

 @Data
 @Builder
public class DeptVO /* extends Object */ { // Object -> 따로 명시되어있지 않아도 상속을 받고있는 상태.
  private int deptno;
  private String dname;
  private String loc;

  // 디폴트 생성자는 필요없지만 파라미터가 있는 생성자가 하나라도 선언되면 제공하는 것을 원칙으로 한다.
  public DeptVO() {

  }

  public DeptVO(int deptno, String dname, String loc) {
    this.deptno = deptno;
    this.dname = dname;
    this.loc = loc;
  }

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
