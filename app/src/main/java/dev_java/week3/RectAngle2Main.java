package dev_java.week3;

/*
 * 메소드 꺼낸다 - 사용자 정의 메소드 구현
 * 리턴타입을 결정하자
 * void일 때
 * 
 * int일 때
 * 
 * 출력하기 - where?
 * 
 * 파라미터의 갯수를 나는 결정할 수 있다.
 * 또 파라미터의 타입도 선택할 수 있다.
 */

//이 경우 둘다 public일 수 없다.
class RectAngle2 {
  // 메소드를 같은 이름으로 했다면 - 메소드 오버로딩을 따져야 함. 파라미터의 개수가 다른지...
  public void calculate1(int x, int y) {
    int area = 0;
    area = x * y;
    System.out.println("반환타입 void 메소드로 계산한 사각형의 면적 : " + area);
  }

  public int calculate2(int x, int y) {
    int area = x * y;
    return area;
  }

  public long calculate2(long x, int y) {
    return x * y;
  }
}

public class RectAngle2Main {
  public static void main(String[] args) {
    RectAngle2 r2 = new RectAngle2();
    int x = 2;
    int y = 3;
    r2.calculate1(x, y);
    int area;
    area = r2.calculate2(x, y);
    System.out.println("반환타입 int 메소드로 계산한 사각형의 면적 : " + area);
    System.out.println("반환타입 int 메소드로 계산한 사각형의 면적 : " + r2.calculate2(2L, y));
  }

}
