package dev_java.week5;

class Sup {
  Sup() {// 부모 디폴트 생성자 선언하기
  }

  public void m() {
    System.out.println("Sup m()호출");
  }
}

class Sub extends Sup {
  Sub() {// 자손 디폴트 생성자 선언하기
    // super.m();
    this.m();
  }

  @Override
  public void m() {
    System.out.println("Sub m()호출");
  }
}

public class SupNSubMain {
  public static void main(String[] args) {
    // insert here
    Sup sup = new Sup();
    // sup.m();

    Sub sub = new Sub();
    // sub.m();

    // 앞(선언부)에 상위클래스/인터페이스가 와야함 뒤쪽에는 하위클래스
    // 자바는 c++과 다르게 생성부의 이름으로 생성됨
    Sup s = new Sub(); // -> Sup의m(부모의 메소드)는 shadow메소드(은닉 메소드)가 됨
    // s.m();

    // 아래에서 sup을 대입하는 경우에는 실제 생성된 객체도 super타입임
    // 따라서 강제 형변환을 하더라도 그래서 문법적인 문제는 해결을 했어도 실제로 가리키는
    // 객체는 상위 객체이므로 에러가 발생함
    // 그러나 s로 하게되면 실제 생성된 객체가 자손인 sub타입이니까
    // 타입은 달라서 강제형변환해야 하지만 실제 가리키는 객체가 자손 타입이므로 에러없이 실행 잘 됨
    // sub = (Sub) sup;// sub = new Sup(); -> ClassCastException
    // sub.m();

    int i = (int) 23.5d;
    System.out.println(i); // 23

    sub = (Sub) s;
    s.m();
  }
}
