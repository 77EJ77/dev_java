package dev_java.test01;

public class Test1_2 {
  public static void main(String[] args) {
    String str = null;
    if ("exit".equals(str)) {
      // equals 앞에 상수를 적어줘야 좋음. 앞에 NULL이 들어오면 터짐
      // 뒤에는 NULL들어와도 안터짐.
    }
    if (str.equals("exit")) {

    }
  }
}
