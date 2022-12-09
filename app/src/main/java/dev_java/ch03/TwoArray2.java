package dev_java.ch03;

public class TwoArray2 {
  public static void main(String[] args) {
    int arr[][] = new int[4][3];
    arr[0] = new int[3];
    arr[1] = new int[4];
    arr[2] = new int[5];
    arr[3] = new int[6];
    for (int i = 0; i < arr.length; i++) {
      System.out.println("arr[" + i + "] 의 길이 : " + arr[i].length);
    }

    int arr2[][] = new int[3][3];
    arr2[0] = new int[] { 1, 2, 3 };
    arr2[1] = new int[] { 4, 5, 6 };
    arr2[2] = new int[] { 7, 8, 9 };
    // insert here - 5
    System.out.println(arr2[1][1]);
    // 9
    System.out.println(arr2[2][2]);
  }
}
