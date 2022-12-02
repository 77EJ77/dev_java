package dev_java.ch01;

public class MemberAction {
  // 회원가입이 성공하면 1을 반환하고 회원가입이 실패하면 0을 반환.

  // 회원가입을 처리하는 메소드 선언하기
  public int memberInsert(String mem_id, String mem_pw, String mem_name) {
    System.out.println("memberInsert 호출 - 파라미터 3개");
    // MemberVO mv = new MemberVO();
    // mv.setMember_id(mem_id);
    // mv.setMember_pw(mem_pw);
    // mv.setMember_name(mem_name);

    int result = -1;
    // if (mv.getMem_id().equals(mem_id) && mv.getMem_pw().equals(mem_pw) &&
    // mv.getMem_name().equals(mem_name))
    // result = 1;
    // else
    // result = 0;
    return result;
  }

  public int memberInsert(MemberVO memVO) {
    System.out.println("memberInsert호출 - 파라미터 1개");
    int result = -1;
    return result;
  }

  public static void main(String[] args) {
    // insert here - memberInsert 메소드 호출하시오.
    // MemberAction ma = new MemberAction();
    // int result = ma.memberInsert("id", "pw", "name");
    // if (result == 0)
    // System.out.println("가입 실패");
    // else if (result == 1)
    // System.out.println("회원가입을 성공하셨습니다.");
    // else
    // System.out.println("관리자에게 문의하세요.");

    MemberAction ma = new MemberAction();
    // ma.memberInsert(null, null, null);
  }
}
