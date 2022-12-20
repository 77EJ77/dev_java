package dev_java.week4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 직관적이다.
@Data
@NoArgsConstructor // 디폴트 생성자 생성용
@AllArgsConstructor // 변수를 전부 받는 생성자 생성용 -> 그 외의 생성자는 따로 작성해줘야 하는 모양.
class CarVO {
  private int speed;
  private String carColor;
  private String wheelNum;

  CarVO(int speed) {
    this.speed = speed;
  }

  CarVO(int speed, String color) {
    this.speed = speed;
    this.carColor = color;
  }
}

public class CarVOMain_2 {
  public static void main(String[] args) {

    CarVO cv = new CarVO();
    System.out.println(cv.toString());
    cv = new CarVO(20);
    System.out.println(cv.toString());
    cv = new CarVO(30, "흰색");
    System.out.println(cv.toString());
    cv = new CarVO(40, "파란색", "8");
    System.out.println(cv.toString());

    DeptVO dvo = DeptVO.builder().deptname("총무부").build();// 아마 생성해주는 용도로 보이는데 굳이 왜..?
    DeptVO dvo2 = DeptVO.builder().deptno(10).loc("인천").deptname("총무부").build();
    System.out.println(dvo.getDeptname() + ", " + dvo.getDeptno() + ", " + dvo.getLoc());
    System.out.println(dvo2.getDeptname() + ", " + dvo2.getDeptno() + ", " + dvo2.getLoc());

  }
}
