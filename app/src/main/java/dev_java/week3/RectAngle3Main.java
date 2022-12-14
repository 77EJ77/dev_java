package dev_java.week3;

/*
 * 배열로 처리해 보기
 * 소스 리뷰 - 관전 포인트
 * 1.1, 1.2
 * 대
 * 1.3
 * 
 * 어느 쪽이 직관적인가?
 * 어느 쪽이 더 양이 많은가?
 * : 양만 많은가? 아니면 복잡도도 늘었나?
 * 어느쪽이 재사용이 좋은가? - 결합도가 높은 코드인가? 아니면 낮은 방식인가? - 이식성과 관계있다
 */
class RectAngle3 {
  public void calculate1(int[] list) {
    int area = 0;
    area = list[0] * list[1];
    System.out.println("반환타입 void 메소드로 계산한 사각형의 면적 : " + area);
  }

  public int calculate2(int[] list) {
    int area = 0;
    area = list[0] * list[1];
    return area;
  }
}

public class RectAngle3Main {
  public static void main(String[] args) {
    RectAngle3 r3 = new RectAngle3();
    int[] list = new int[] { 3, 4 };
    r3.calculate1(list);
    int area;
    area = r3.calculate2(list);
    System.out.println("반환타입 int 메소드로 계산한 사각형의 면적 : " + area);
  }
}
