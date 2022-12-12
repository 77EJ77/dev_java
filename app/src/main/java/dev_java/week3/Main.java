package dev_java.week3;

public class Main {
  int i = 1;
  boolean isOk[] = new boolean[3];// false, false, false
  boolean isOk2[];

  // 디폴트 생성자는 생략이 가능함.
  // 그러나 지금은 isOk배열의 생성을 위해서 getIsOk()를 경유 하도록 해야지 NullPointerException을 피할 수 있다.
  public Main() {
    System.out.println("Main() 디폴트 생성자 호출 성공");
    getIsOk2();
  }

  // 선언과 동시에 인스턴스화를 하지 않는 경우를 게으른 인스턴스화라고 함.
  // 선언과 생성을 동시에 하지 않고 메소드를 통해서 객체 주입을 받을 수 있음.
  // 이런 경우 메소드 안에서 if문을 통해 널체크를 할 수 있어 싱글톤 패턴으로 객체를 주입 받을 수 있어
  // 현업에서 선호하는 객체 주입 방법 중 하나임.
  boolean[] getIsOk2() {
    if (isOk2 == null) {
      isOk2 = new boolean[] { true, false, true };
    }
    return isOk2;
  }

  public static void main(String[] args) {
    Sub sub = new Sub();// 이게 디폴트 생성자 호출이었다니... 생각없이 살았다
    System.out.println(sub.j);
    sub.methodSub();
  }

}
