package dev_java.test1221;

public class Test02 {
  public static void main(String[] args) {
    // String[] sArr = { "사과", "딸기", "오렌지" };

    for (int i = 2; i < 9; i += 2) {
      System.out.println(2 + "*" + i + "=" + (2 * i));
    }

    String[] sArr = { "빨강", "노랑", "파랑" };
    for (int i = 0; i < sArr.length; i++) {
      System.out.print(sArr[i] + " ");
    }
    System.out.println();
    for (String s : sArr) {
      System.out.print(s + " ");
    }
  }
}
