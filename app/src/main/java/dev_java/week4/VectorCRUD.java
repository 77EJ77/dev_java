package dev_java.week4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
//List - 순서, 느리다, 정렬(2차가공-속도-3초조회), 추가하면 맨 뒤에 채운다.
//index가 다르면 중복값 저장 가능

import javax.swing.JOptionPane;

public class VectorCRUD {
  static Vector<String[]> vdept = new Vector<>();
  static Vector<DeptVO> vdept2 = new Vector<>();

  public void getDeptList() {
    for (int i = 0; i < vdept.size(); i++) {
      String[] oneRow = vdept.get(i);
      for (int j = 0; j < oneRow.length; j++) {
        System.out.print(oneRow[j] + ", ");
      }
      System.out.println();
    }
  }

  // 벡터에 부서정보 추가하기 - 없는 데이터를 새로 추가
  // pass by value로 호출하는 경우 주소번지를 받아옴 - 원본을 받는 것 main.ival, sub.ival
  public int deptInsert(String[] str) {// 지역변수 - 메소드 영역 안에서..
    System.out.println("부서 정보 입력 호출");
    int result = 0;// 1이면 성공, 0이면 실패
    if (vdept.contains(str)) {
      System.out.println("이미 존재하는 데이터입니다.");
      return result;
    }
    boolean isOk = vdept.add(str);
    if (isOk)
      result = 1;
    return result;
  }

  /**
   * 벡터에 부서정보 수정하기 - 있는 데이터를 변경
   * 
   * @param index 수정하고자하는 부서번호
   * @param str   수정할 문자열 배열
   * @return 1이면 성공 0이면 실패
   */
  public int deptUpdate(int index, String[] str) {
    System.out.println("부서 정보 수정 호출");
    int result = 0;// 1이면 성공, 0이면 실패
    // if (!vdept.contains(str)) {
    // System.out.println("존재하지 않는 데이터입니다.");
    // return result;
    // }
    // vdept.remove(index);
    // boolean isOk = vdept.add(str);
    // if (isOk)
    // result = 1;
    String[] oneRow = null;
    here: for (int i = 0; i < vdept.size(); i++) {
      String row[] = vdept.get(i);
      for (int j = 0; j < row.length; j++) { // String[]돌림
        if (oneRow[0].equals(row[0])) {
          String[] updRow = { oneRow[0], str[1], str[2] };
          // 수정이라 말하고 입력으로 처리함 - 한 셀씩 수정하는 것
          vdept.remove(i);// i번째 자리를 삭제하고
          // Vector를 사용하면 배열의 모든 단점을 보완함 - 고정, 타입단점
          // Vector<Object>
          vdept.add(i, updRow);// 삭제된 자리에 추가함 - 배열의 장애 - int i[] = new int[3];
          vdept.set(index, updRow);
          // break문만 사용시 이중 for문에서 내부for문만을 탈출하게 되는데 여기서는 외부 for문을 빠져나가야 하므로 라벨문을 붙여서 처리함
          break here;
        } else {
          System.out.println("선택한 부서번호와 벡터에서 가져온 부서번호가 다르다.");
        }

      }
    }
    getDeptList();
    return result;
  }

  // 벡터에 부서정보 삭제하기 - 있는 데이터를 삭제
  // 벡터에 있는 부서 정보 중에서 어떤 로우를 삭제할 건지 부서번호를 받아와야 함
  // 이것은 사용자로부터 받아와야 하는 값임
  // 그런데 int형 그런데 String[]에서 부서번호는 String타입
  // 그러니까 형변환 필요. -그런데 null이 오면 NumberFormatException발생할 가능성 있음
  // 방어코드 작성 필요함. - null에 대한 이슈는 현재 프로그래밍에 있어 심각한 장애로 인식 - 중요한 문제임
  public int deptDelete(int index) {
    System.out.println("부서 정보 삭제 호출");
    int result = 0;// 1이면 성공, 0이면 실패
    // if (index < 0 || index > vdept.size()) {
    // System.out.println("존재하지 않는 데이터입니다.");
    // return result;
    // }
    // vdept.remove(index);
    // result = 1;
    for (int i = 0; i < vdept.size(); i++) {
      String oneRow[] = vdept.get(i);
      int deptno2 = 0;
      // 예외 발생에 대한 우려 방어코드 작성함
      if (oneRow[0] != null) {// null체크를 했다 - 이것까지도 프레임워크에서 떠안으려 하고 있다. 이미 떠안았다.
        deptno2 = Integer.parseInt(oneRow[0]);
      }
      // 사용자가 선택한 부서 번호와 벡터에 있는 부서번호를 비교하여 같은 것 찾기함
      if (index == deptno2) {
        // 삭제할 벡터의 로우값이 필요함 - 이것은 벡터의 size를 통해 찾아냄
        // 여기서는 변수 i가 인덱스 값에 해당함.
        // remove 메소드의 파라미터가 int인 경우에 대해서만 삭제된 벡터의 제네릭 반환해줌. 그것을 받아서 처리 여부 확인 가능함.
        String[] deleteRow = vdept.remove(i);// 삭제된 1차배열 반환
        // boolean isOk = vdept.remove(oneRow);// 삭제 여부 반환 // 메소드 오버로딩이라고 함
        // 삭제한 객체가 존재하는가 y:삭제됨 n:삭제 안됨
        if (deleteRow != null) {
          JOptionPane.showMessageDialog(null, "삭제 처리 되었습니다.");
          // 삭제처리가 성공한 경우이므로 반환값 1 리턴해줌.
          result = 1;
        }
      }
    }
    return result;
  }

  // 벡터에 부서정보 상세보기 - 있는 데이터를 하나 꺼내 봄
  public String[] deptDetail(int index) {
    System.out.println("부서 정보 상세보기 호출");
    String[] oneRow = new String[3];
    if (index < 0 || index > vdept.size()) {
      System.out.println("존재하지 않는 데이터입니다.");
      return null;
    }
    for (int i = 0; i < vdept.size(); i++) {
      if (index == i) {
        oneRow = vdept.get(index);
      }
    }
    return oneRow;
  }

  public static void main(String[] args) {
    VectorCRUD vCrud = new VectorCRUD();
    int deptno = 10;
    String dname = "개발부";
    String loc = "인천";
    String[] oneRow = { "10", "인사부", "인천" };
    String[] oneRow2 = { "20", dname, loc };

    // 입력 테스트
    int result = vCrud.deptInsert(oneRow);
    if (result == 1) {
      JOptionPane.showMessageDialog(null, "등록이 되었습니다.");
      return;// 조건문안에 return문 해당 메소드 블록을 빠져나간다.
    }
    System.out.println("입력 테스트 : " + result);
    // 수정 테스트
    System.out.println("수정 테스트 : " + result);
    result = vCrud.deptUpdate(0, oneRow);
    Scanner sc = new Scanner(System.in);
    System.out.print("수정할 부서번호를 입력하세요. : ");
    int user = sc.nextInt();
    System.out.print("수정할 부서명을 입력하세요. : ");
    String user_dname = sc.nextLine();
    System.out.print("수정할 지역을 입력하세요. : ");
    String user_dloc = sc.nextLine();
    StringTokenizer st = new StringTokenizer(user_dname, "|"); // |를 구분자로 삼아 스트링 값 쪼개기
    user = Integer.parseInt(st.nextToken());
    user_dname = st.nextToken();
    user_dloc = st.nextToken();
    String[] str = { user + "", user_dname, user_dloc };
    vCrud.deptUpdate(user, str);
    // System.out.println(Arrays.toString(vCrud.deptDetail(0)));
    // 삭제 테스트
    // result = vCrud.deptDelete(0);
    // System.out.println("삭제 테스트 : " + result);
    System.out.print("삭제할 부서 번호를 입력하세요 : ");
    user = sc.nextInt();
    int result3 = vCrud.deptDelete(user);
    if (result3 == 1) {
      JOptionPane.showMessageDialog(null, "삭제되었습니다.");
      // return;
    }
    sc.close();
    // 상세보기 테스트
    System.out.println(Arrays.toString(vCrud.deptDetail(0)));
    System.out.println(vdept.get(0)[0]);

  }// end of main
}
