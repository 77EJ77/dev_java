package dev_java.baseball;

public class BaseballGameLogic {

  /**
   * 입력받은 값으로 결과 확인하고 결과 담은 배열 리턴
   * 
   * @param comList  랜덤 생성한 세가지 수
   * @param userList 유저에게 입력받은 세가지 수
   * @return 결과값 배열
   */
  public int[] checkNum(int[] comList, int[] userList) {
    int[] result = new int[2];
    int strike = 0;
    int ball = 0;

    for (int i = 0; i < comList.length; i++) {
      for (int j = 0; j < userList.length; j++) {
        if (comList[i] == userList[j]) {
          if (i == j) {
            strike++;
            break;
          } else {
            ball++;
            break;
          }
        }
      }
    }
    result[0] = strike;
    result[1] = ball;
    return result;
  }

  /**
   * 유저에게 입력받은 값에 중복이 있는지 확인
   * 
   * @param userList 유저에게 입력받은 세가지 수
   * @return 중복체크 결과값 0:중복X 1:중복O
   */
  public int check_user_num(int[] userList) {
    int result = 0;
    for (int i = 0; i < userList.length - 1; i++) {
      for (int j = i + 1; j < userList.length; j++) {
        if (userList[i] == userList[j]) {
          result = 1;
          return result;
        }
      }
    }
    return result;
  }

  /**
   * 랜덤 배열 생성해서 리턴
   * 
   * @return comList
   */
  public int[] mkNumber() {
    int comList[] = new int[3];
    comList[0] = (int) (Math.random() * 10);
    do {
      comList[1] = (int) (Math.random() * 10);
    } while (comList[0] == comList[1]);
    do {
      comList[2] = (int) (Math.random() * 10);
    } while (comList[0] == comList[2] || comList[1] == comList[2]);
    return comList;
  }
}
