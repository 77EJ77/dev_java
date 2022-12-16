package dev_java.Quiz03;

/**
 * 연습문제 3
 * 0 부터 9사이의 임의의 수를 100개를 채번하여 한 줄에 10개씩
 * 출력하고 그 숫자의 빈도수를 계산하여 출력하시오
 * 원본 : 0 1 2 3 4 5 6 7 8 9
 * 2 5 6 8 7 8 9 0 1 1
 * 5
 * 3
 * 3
 * 7
 * 9
 * 2
 * 0 4 5 6 6 7 8 8 9 9
 * 숫자 : 0 1 2 3 4 5 6 7 8 9
 * 갯수 : 10 9 18 11 7 9 15 14 7 5
 */
public class Quiz3 {
  int count[] = new int[10];

  int[] initArray(int datas[], int size) {
    int i;
    for (i = 0; i < datas.length; i++) {
      datas[i] = (int) (Math.random() * 10);
    }
    dataPrint(datas);
    return datas;
  }

  void dataPrint(int[] datas) {
    for (int i = 0; i < datas.length; i++) {
      System.out.print(datas[i] + " ");
      if (i % 10 == 9)
        System.out.println();
    }
  }

  void count(int[] datas) {
    // int index = 0;
    for (int i = 0; i < datas.length; i++) {
      // for (int j = 0; j < 10; j++) {
      // if (datas[i] == j)
      // count[j] += 1;
      // }
      // index = datas[i];
      // count[index]++;
      count[datas[i]]++;
    }
    for (int i = 0; i < count.length; i++) {
      System.out.println(i + "의 빈도 : " + count[i]);
    }
  }

  public static void main(String[] args) {
    int datas[] = new int[100];
    Quiz3 q3 = new Quiz3();
    q3.initArray(datas, 100);
    q3.count(datas);
  }
}
