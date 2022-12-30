package dev_java.week6;

public class T {
  ZipCodeSearch z = null;

  // 메소드를 통해서도 객체주입을 받을 수 있다 - 싱글톤패턴
  public ZipCodeSearch getInstance() {
    if (z == null) {// 조건부로
      z = new ZipCodeSearch();
    }
    return z;
  }

  public static void main(String[] args) {
    T t = new T();
    t.z = t.getInstance();
    t.z.getZipcode("청룡동");
  }
}
