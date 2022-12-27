package dev_java.network3;

public class MySonata extends MyCar {

  MySonata() {
    System.out.println("MySonata 호출 성공");
  }

  @Override
  public void display() {
    System.out.println("나는 2023년형 소나ㅏ타");
  }

  public static void main(String[] args) {
    MySonata ms = new MySonata();// 부모클래스 먼저 로딩 따로 인스턴스화 하지 않아도
  }

}
