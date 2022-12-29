package dev_java.oracle;

// Object클래스에는 toString()정의되어있다.
// 모든 클래스는 toString()오버라이딩할 수 있다.
public class Pride {

  // @Override
  // public String toString() {
  // return "Pride 자동차입니다.";
  // }

  public static void main(String[] args) {
    Pride p = new Pride();
    System.out.println(p);// 주소
    System.out.println(p.toString());// 주소
  }
}
