package dev_java.oracle;

import java.util.ArrayList;
import java.util.List;

import dev_java.week4.DeptVO;

public class ListExam1 {

  public static void main(String[] args) {
    List<DeptVO> deptList = new ArrayList<>();
    DeptVO dv = DeptVO.builder().deptno(10).deptname("이상해").loc("??").build();
    deptList.add(dv);
    dv = DeptVO.builder().deptno(20).deptname("대체뭐냐").loc("ㅇㅇㅇ").build();
    deptList.add(dv);
    dv = DeptVO.builder().deptno(30).deptname("개발부").loc("난 컴퓨터랑 안맞음").build();
    deptList.add(dv);

    for (DeptVO dd : deptList) {
      System.out.println(dd.getDeptno() + ", " + dd.getDeptname() + ", " + dd.getLoc());
    }
  }

}
