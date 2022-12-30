package dev_java.week6;

class Sup {
  void go() {
    System.out.println("Sup go 호출");
  }

  void stop() {
    System.out.println("Sup stop 호출");
  }
}

class Sub extends Sup {

  Sub() {
    super.stop();
    // 현재 활성화 되어 있는...
    this.stop(); // 현재 인스턴스화 되어있는 생성된 객체 -> 최초로 생성되었을 때 메모리에 살아있는 객체 - 원본인
  }

  @Override
  void stop() {
    System.out.println("Sub stop 호출");
  }
}

public class SuperMain {
  public static void main(String[] args) {
    Sup sup = new Sup();
    // sup.stop();
    Sub sub = new Sub();
    // sub.go();// 재사용성 // 하위에 있는 것(가장 자식 클래스?)을 상속받아야 누릴 수 있는 게 더 많아짐.
    sup = sub;// 얕은 복사 -> 원본을 바꾸면 복사본도 바뀐다!
    // sup = new Sub(); 이거 아님?
    // 이럴때 부모가 가진 stop 메소드는 은닉 메소드라고 함 shadow method라고 함
    sup.stop();
    // this, super는 static이 있는 메소드 영역에서 사용불가함 -> 컴파일 자체를 허용 안해줌 -> 컴파일 에러 발생함
    // super.stop();
    // sub.stop();

  }
}
