package dev_java.week4;

public class test01 {
  public static void main(String[] args) {
    DeptVO d1 = DeptVO.builder().deptno(10).build();
    System.out.println(d1);
    System.out.println(System.identityHashCode(d1));
    d1 = DeptVO.builder().deptname("케이크먹는부").loc("제주").build();
    System.out.println(d1);
    System.out.println(System.identityHashCode(d1));
  }
}
