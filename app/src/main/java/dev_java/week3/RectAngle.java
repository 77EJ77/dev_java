package dev_java.week3;

/*
 * 1-1
 * RectAngle.java
 * 메인메소드 안에서 처리하기
 * 
 * 
 * 문제 제기
 * 원의 면적도 구하고 싶다면?
 * 
 * 삼각형의 면적도 구하자고 하면?
 * 
 * 사각형의 면적도 구해야 하면?
 */
public class RectAngle {
  public static void main(String[] args) {
    // 변수 선언 2개 - 가로길이, 세로길이
    // 변수 선언 1개 - 면적구하기
    int width = 2;
    int height = 3;
    int area = 0;
    area = width * height;
    System.out.println("직사각형의 면적은? :" + area);
  }
}
/**
 * 자바에서는 같은 이름의 메소드를 선언할 수 있다.
 * 단, 두 가지 규칙이 있는데
 * 하나는 메소드 오버라이딩이고
 * 하나는 메소드 오버로딩이다.
 * 공통점 : 메소드 이름이 같을 때만 따진다.
 * 오버라이딩의 경우에는 서로 상속관계에 있거나 인터페이스의 구현체 클래스인 경우에만 따진다. 관계가 없다면 잊어라.
 */