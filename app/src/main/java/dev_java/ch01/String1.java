package dev_java.ch01;

public class String1 {
  public static void main(String[] args) {
    String s1 = "안녕";
    String s2 = "안녕";
    String s3 = new String("안녕");
    String s4 = new String("안녕");
    // insert here
    // s1와 s2의 주소번지는 같니? 참 혹은 거짓 선택하기
    // 그리고 이유에 대해 옆사람과 토론해보세요
    // s3과 s4의 주소번지가 같니? 다르니? 선택한 후 결과에 대해 말해보세요
    // 만일 s3이 가리키는 문자열이 s4와 같은지를 비교하려면 어떡하지? 구글링해서 확인해보기

    System.out.println(s1 == s2);
    System.out.println(s3 == s4);
    System.out.println(s3.compareTo(s4));
  }
}
