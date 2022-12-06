package dev_java.ch02;

/**
 * 3가지 - 타입
 * 부서번호
 * 사원번호
 * ...
 */
public class DeptList {
  // 선언부.
  // 원시형 타입만 올 수 있다. vs 참조형 타입도 선언할 수 있다.
  // 전역에서 사용할 수 있다.
  // 마침표 다트연산자. 앞에는 소유주인 인스턴스변수가 옴. 뒤에는 변수or메소드
  public static void main(String[] args) {
    int deptnos[]; // -> 이 상태에서 바로 사용 불가능. NullPointerException이 발생함. 생성을 하지 않음.
    // deptnos = new int[3]; // -> 내부값 0으로 초기화
    deptnos = new int[] { 0, 0, 1 };
    // deptnos = {0,0,0}; //선언할 때 함께 초기화해주지 않으면 이 방법으로 따로 초기화는 안되는 듯.
    System.out.println(deptnos[0]);
    System.out.println(deptnos[1]);
    System.out.println(deptnos[2]);

    // for문의 고전 형태.
    for (int i = 0; i < deptnos.length; i++) {
      System.out.println(deptnos[i]);
    }

    // 개선된 형태의 for문
    for (int i : deptnos) { // int i -> 배열의 타입(배열의 요소 하나를 가리킴.) // deptnos -> 배열의 주소번지를 가리킴.
      System.out.println(i);// 전체 원소를 다 출력할 때는 개선된 for을 사용. 배열의 형태로 불러올 필요 없음.
    }
  }
}
