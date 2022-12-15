package dev_java.tables;

public class StringCopy {
  public static void main(String[] args) {
    String str = "Hello";
    String str1 = "Hello";

    // 둘다 참이 나옴.
    System.out.println(str == str1); // 주소가 같니?
    System.out.println(str.equals(str1)); // 주소가 가리키는 값이 같니?

    String str2 = new String("Hello");
    String str3 = new String("Hello");

    System.out.println(str2 == str3); // 주소가 같니? false
    System.out.println(str2.equals(str3)); // 주소가 가리키는 값이 같니? true

  }
}
