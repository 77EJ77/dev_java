package dev_java.ch01;

public class MemberVOMain {
  public static void main(String[] args) {
    MemberVO memVO = new MemberVO();
    String user_id = "tomato";
    // MemberVO클래스에서 mem_id는 접근제한자를 private으로 했으므로
    // 외부에서 접근이 불가하다.
    // 그래서 setter메소드를 제공하고 있다.
    // private 으로 선언된 변수는 클래스 외부에서 사용이 불가함 - 보안 - 캡슐화
    // System.out.println(memVO.getMem_id());
    memVO.setMember_id(user_id);
    System.out.println(memVO.getMem_id());// tomato
    // mem_name의 경우 접근제한자를 public으로 했으므로 직접 초기화가 가능하다.
    memVO.setMember_id("tomato");
    // String name

  }
}
