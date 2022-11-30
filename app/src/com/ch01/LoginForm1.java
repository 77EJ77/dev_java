package app.src.com.ch01;

public class LoginForm1 {
	public String login(String id, String pw) {
		System.out.println("로그인 호출 성공");
		String mem_name = null;// 변수 선언만 했다. 초기화는 안했다. null은 모른다. 미정이다.
		mem_name = "강감찬";// 6번에서 선언한 변수의 초기화. 디폴트값이 강감찬
		return mem_name;
	}

	// non-static인 메소드는 가능함.
	void methodA() {
		login("", "");
	}

	// 괄호가 있으면 메소드이거나 생성자이다.
	public static void main(String[] args) {
		// static 영역 안에서 non-static 메소드는 호출이 불가함.
		LoginForm1 lf1 = new LoginForm1();
		// insert here - 강감찬
		String rmem_name = lf1.login("", "");
		System.out.println(rmem_name);
		System.out.println(lf1.login("", ""));
	}
	// 1.static을 붙여서 해결할 수 있다.
	// 2.인스턴스화를 해서 해결할 수 있다.
}
