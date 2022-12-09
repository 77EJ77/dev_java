package dev_java.ch03;

//2차배열 -> List<Map<>> 제네릭 -> 웹개발, 앱개발(하이브리드앱) - JSON
public class TwoArray1 {
  void toWhile(int[][] arr) {
    int i = 0;
    while (arr.length > i) {
      int j = 0;
      while (arr[i].length > j) {
        System.out.println("arr[" + i + "][" + j + "] = " + arr[i][j]);
        j++;
      }
      i++;
    }
  }

  public static void main(String[] args) {
    int arr[][] = new int[2][3];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = i + j;
        System.out.println("arr[" + i + "][" + j + "] = " + arr[i][j]);
      } // end of inner
    } // end of outter

    TwoArray1 ta1 = new TwoArray1();
    ta1.toWhile(arr);
  }
}
