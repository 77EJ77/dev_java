package dev_java.ch02;

public class Switch1 {
  public static void main(String[] args) {
    String bread = "도넛";
    switch (bread) {
      case "소보로": {
        int protocol = 100;
        System.out.println("소보로 빵 입니다.");
        break;
      }
      case "도넛": {// 스코프 안에서 아래와 같은 변수를 지역변수처럼 독립적으로 사용 가능.
        int protocol = 200;
        System.out.printf("%s 빵입니다. %d원입니다.%n", bread, protocol);
        break;
      }
      default:
        System.out.println("원하는 빵이 없습니다.");
        break;
    }// end of switch
  }
}
