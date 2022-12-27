package dev_java.network3;

public class ServerTest {
  public static void main(String[] args) {
    // 인스턴스화를 하면 생성자(디폴트)도 호출된다
    // 아래 중에서 생성자 안에 메소드 호출구문이 있는 쪽은 어딘가요
    BananaServer bs = new BananaServer();
    KiwiServer kw = new KiwiServer();
  }
}
