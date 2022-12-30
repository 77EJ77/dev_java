package dev_java.week6;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Y {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();

    Vector<Integer> vList = new Vector<>();
    Integer[] is = new Integer[3];
    is[0] = 1;
    is[1] = 2;
    is[2] = 3;
    list.copyInto();// 불가하다. 인터페이스 List 안에 copyInto 메소드는 정의되어있지 않음
    vList.copyInto(args);
  }
}
