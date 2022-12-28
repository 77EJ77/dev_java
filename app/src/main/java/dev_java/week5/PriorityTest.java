package main.java.dev_java.week5;

public class PriorityTest extends Thread {
  // Field
  private String threadName; // 스래드 이름 기억용
  // Constructor

  public PriorityTest(String threadName) {
    this.threadName = threadName;
  }

  // Method
  @Override
  public void run() {
    // 스래드 이름 출력 3번 반복
    for (int i = 0; i < 3; i++) {
      // System.out.println(threadName + "가 구동됨.");
      System.out.println(this.getName() + "가 구동됨.");// JVM이 부여하는 thread이름
    }

  }

  public static void main(String[] args) {
    // 우선 순위 테스트용
    // 나는 Thread를 상속 받았다 - 그 말은 내 생성자가 호출되면 그보다 먼저 Thread생성자가 호출됨
    // 상위클래스의 생성자가 먼저 호출됨 메소드오버로딩/오버라이딩의 규칙이 지켜지는지 확인해야하니까
    // 클래스가 클래스이면서 동시에 Thread일 수 있음
    Thread t1 = new PriorityTest("제일 높은 스래드");
    Thread t2 = new PriorityTest("보통 스래드");
    Thread t3 = new PriorityTest("제일 낮은 스래드");
    t1.setPriority(Thread.MAX_PRIORITY); // 10 - 가중치 - 절대적이지 않음
    t2.setPriority(Thread.NORM_PRIORITY); // 5
    t3.setPriority(Thread.MIN_PRIORITY); // 1
    t1.start();
    t2.start();
    t3.start();
  }
}