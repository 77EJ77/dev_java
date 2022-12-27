package dev_java.network3;

import javax.swing.JFrame;

public class BananaServer extends JFrame {
  // 생성자
  BananaServer() {
    System.out.println("바나나톡 생성자 호출");
    initDisplay();
  }

  BananaServer(String title) {
    super(title); // super는 JFrame이다 -> 지변의 성격이나 전변에 반영됨
    // 아래서 this는 BananaServer를 가리키는 것임
    // this(title);// 자기자신을 호출하는 것이므로 에러임
    initDisplay();
    // this.setTitle(title);
  }

  public void initDisplay() {
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    // this.setTitle("바나나톡");
    this.setVisible(true);
    this.setSize(400, 300);
  }

  // this는 클래스 쪼개기 즉 화면과 로직의 분리 또는 하나의 클래스를 여러 개의 클래스로 나누어(분업) 처리할 때만 필요하다
  // -this(), this("안녕")-실무에서 사용할 일이 없다
  public static void main(String[] args) {
    System.out.println("메인 메소드 호출");
    // 생성자 파라미터에는 this말고도 다른 타입을 사용가능함 - String
    // new BananaServer("생성자 파라미터로 제목을 결정함-초기화");
    new BananaServer("wannagohome");
  }
}
/*
 * 관전포인트
 * initDisplay를 메인메소드에서 호출하는 것과 생성자 안에서 호출하는 것이 가능하다
 * 그렇다면 둘의 차이는 있나? 없나?
 * 
 * 작업지시서
 * 키위톡은 메인메소드에서 initDisplay호출함
 * 바나나톡은 생성자에서 initDisplay호출함
 */