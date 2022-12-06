package dev_java.ch02;

public class NansuMaker {
  // 만일 여기서 채번한 값을 다른 클래스에서 재사용해야 한다면 그런 상황이면 나는 전역변수(멤버변수)로 결정한다
  int com[] = new int[3];
  int my[] = new int[3];

  // 난수 발생하여 3자리의 서로 다른 숫자로 된 값을 배열에 담기
  public void ranCom() {
    com[0] = (int) (Math.random() * 10);
    do {
      com[1] = (int) (Math.random() * 10);
    } while (com[0] == com[1]);
    // insert here
    do {
      com[2] = (int) (Math.random() * 10);
    } while (com[0] == com[2] || com[1] == com[2]);
    // for (int i : com) {
    // System.out.print(i);
    // }
  }

  public static void main(String[] args) {
    NansuMaker nm = new NansuMaker();
    // for (int i = 0; i < 10; i++) {
    nm.ranCom();
    System.out.println(nm.com[0] + ", " + nm.com[1] + ", " + nm.com[2]);
    // }
  }
}
