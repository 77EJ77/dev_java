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
    memVO.setMember_name("user_id");// setter메소드를 호출하는 것만으로 초기화됨.
    System.out.println(memVO.getMem_name());
    // 아래와 같이 setter메소드를 호출하면 전역변수인 mem_pw에 pw가 초기화됨
    memVO.setMember_pw("pw");
    // getter메소드를 호출하면 전변인 mem_pw에 저장된 값이 출력됨.
    // 만일 setter메소드를 호출하지 않으면 null출력될 것임. - 주의할 것.
    System.out.println(memVO.getMem_pw());
  }
}
