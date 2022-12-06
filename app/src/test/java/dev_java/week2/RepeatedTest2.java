package dev_java.week2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RepeatedTest2 {
  @DisplayName("0부터 9사이 숫자 채번하기")
  @RepeatedTest(10)
  void methodA() {
    int com = (int) (Math.random() * 10);
    double com2 = Math.random() * 10;
    System.out.println(com + ", " + com2);
  }
}
