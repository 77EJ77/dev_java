package dev_java.week3;

public class Quiz4 {
  int cnt;// 전역변수가 바뀐다.

  int account(int start, int end) {// start=3, end=13
    // for(int i = start; i < end; i++){
    // 초기값; 조건식; 증감식;
    for (int i = start; i <= end; i = i + 3) {
      cnt++;
    }
    return cnt;
  }

  public static void main(String[] args) {
    Quiz4 q4 = new Quiz4();
    q4.account(3, 13);
    System.out.println(q4.cnt);
  }
}
