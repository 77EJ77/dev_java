package dev_java.week2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("파라미터 테스트 활용")
public class ParameterTest1 {
  @ParameterizedTest // 파라미터 테스트할 때 사용하는 어노테이션. // 파라미터 테스트해주는 어노~
  @ValueSource(ints = { 1, 5 }) // 배열의 초기화 방법
  @DisplayName("ValueSource를 통해서 매개변수를 지정가능")
  void isPositive(int number) {
    assertTrue(number > 0);
  }
}
