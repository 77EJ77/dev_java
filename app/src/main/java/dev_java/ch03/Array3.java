package dev_java.ch03;

import java.util.Arrays;

public class Array3 {
  public static void main(String[] args) {
    int i[] = { 1, 2, 3 };
    int j[];// 원시형 타입이 아님. 주소를 가지는 애라 생성이 안됨.
    // 생성이 안된 상태에서 치환이 가능한가.
    j = i;
    int k[];
    // ↓insert here↓
    k = new int[3];// 생성함.
    j = k;// 왜 에러이죠?? - 에러가 발생하지 않도록 11번 라인에 코드를 추가하세요
    // insert here
    System.out.println(Arrays.toString(j));
    System.out.println(j.length);// 배열의 사이즈 길이
    String s1 = "안녕";
    System.out.println(s1.length());// ()->문자열의 길이
    String s2 = s1;
    System.out.println(s2);
  }
}
