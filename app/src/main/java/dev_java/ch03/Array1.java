package dev_java.ch03;

public class Array1 extends Object {// 상속 - 확장, 재사용(오버라이딩 경우), 재정의해서 쓴다.
  // 상속을 하면 클래스 간의 결합도가 높아짐. -> 단위테스트가 힘듬 -> 통합테스트도 X
  public static void main(String[] args) {
    // int j[3] = new int[3]; -> XXX

    // 선언과 생성을 나누어 할 수 있다.
    // 이른 주입인가 아니면 게으른 주입인가
    // 게으른 인스턴스화 -> 선언과 생성을 분리함.
    // 이른 인스턴스화 -> 선언부에 선언과 생성을 한 번(한 문장)에 작성함.
    int i[];
    i = new int[3];
    // 초기화 없다. 아직... 0 0 0
    // 객체배열 null, null, null
    System.out.println(i[0]);
    int x = 3;
    boolean isOk = false;
    try {// 예외처리
      // 예외가 발생할 가능성이 있는 코드를 감싼다. try-catch로
      // 타입이 어긋나면 문법에러로 Exception과는 상관이 없음.
      // 런타임에러
      System.out.println(i[3]); // -> 터짐
      // System.out.println(i[x]);
      // System.out.println(i[isOk]);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("인덱스가 범위를 넘었다.");
    }
    System.out.println("여기");
  }
}
