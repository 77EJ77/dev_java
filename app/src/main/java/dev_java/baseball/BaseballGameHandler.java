package dev_java.baseball;

public class BaseballGameHandler {

  /**
   * 입력받은 값으로 결과 확인 후 그 결과를 화면에 뿌려줌.
   * 
   * @return result
   */
  public String checkResult() {
    String result = "";
    BaseballGameLogic bgl = new BaseballGameLogic();
    int[] resultList = bgl.checkNum(null, null);
    if (resultList[0] == 3) {
      // 정답일 경우
    } else {
      // 오답일 경우
      result = resultList[0] + "S " + resultList[1] + "B";
    }
    // 결과값 화면에 뿌려줌.
    return result;
  }

  public String checkUserNum(int[] ){
    String result = "";

    BaseballGameLogic bgl = new BaseballGameLogic();
    int result = bgl.check_user_num();
    if(result){

    }

    return result;
  }
}
