package dev_java.week4;

// 직관적이다.
class CarVO {
  private int speed;
  private String carColor;
  private String wheelNum;

  CarVO() {
    // 답은 0, null, 0
  }

  CarVO(int speed) {// new CarVO(30);으로 호출했다면?
    this.speed = speed;
    // 답은 30, null, 0
  }

  CarVO(int speed, String carColor) {// new CarVO(50, "검정색");으로 생성하면?
    this.speed = speed;
    this.carColor = carColor;
    // 답은 50, 검정색, 0
  }

  CarVO(int speed, String carColor, String wheelNum) {// new CarVO(100, "흰색", 4);으로 생성하면?
    this.speed = speed;
    this.carColor = carColor;
    this.wheelNum = wheelNum;
  }

  @Override
  public String toString() {
    return "내 자동차는 " + carColor + "이고, 바퀴수는 " + wheelNum + "개이고, 현재 속도는" + speed + "km/h이다.";
  }

  public int getSpeed() {
    return this.speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public String getCarColor() {
    return this.carColor;
  }

  public void setCarColor(String carColor) {
    this.carColor = carColor;
  }

  public String getWheelNum() {
    return this.wheelNum;
  }

  public void setWheelNum(String wheelNum) {
    this.wheelNum = wheelNum;
  }
}

public class CarVOMain {
  public static void main(String[] args) {
    CarVO cv = new CarVO();
    CarVOMain cvm = new CarVOMain();
    System.out.println(cvm);
    System.out.println(cv);// toString 메소드가 존재할 경우(override) -> 메소드 자동실행

    cv = new CarVO();
    System.out.println(cv.toString());
    cv = new CarVO(20);
    System.out.println(cv.toString());
    cv = new CarVO(30, "흰색");
    System.out.println(cv.toString());
    cv = new CarVO(40, "파란색", "8");
    System.out.println(cv.toString());
  }
}
