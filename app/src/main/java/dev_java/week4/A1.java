package dev_java.week4;

import java.util.Vector;

public class A1 {
  int ival = 1;

  public static void main(String[] args) {
    A1 a = new A1();
    Vector<Integer> v = new Vector<>();
    v.add(a.ival);
    a.ival = 10;
    System.out.println(a);
    a = null;// 객체 초기화하면 다음 라인 넘어갈 때 캔디데이트 상태가 됨
    a = new A1();
    a.ival = 20;
    v.add(a.ival);
    System.out.println(a);// 변수 이름은 같은데 주소가 바뀜
    // insert here -> a.ival에 10을 다시 출력하고싶을 때 어케함?

    a.ival = 10;
    System.out.println(a.ival);

    System.out.println(v.get(0));
  }
}
