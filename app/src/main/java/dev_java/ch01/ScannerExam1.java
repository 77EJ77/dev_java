package dev_java.ch01;

//java.lang패키지 외 클래스들은 모두 import문을 추가해야함 - 하지 않으면 컴파일 에러 - .class생성 안됨.
//클래스의 구성요소2가지 : 명사형==변수==필드, 동사형==메소드 / 최근 코딩은 함수형 프로그래밍 처리방법이 유행임 - 람다식지원 - 일급함수-일급객체
//필드+메소드 => 클래스 정의
//클래스를 인스턴스화 하면 메모리에 로딩이 된다.
//인스턴스화.메소드명();
//인스턴스화.메소드명(int i);
//인스턴스화.메소드명(int i, double d, .....);
//인스턴스화.전역변수(원시형+참조형 모두...);
//static은 하나다. 복제본이 있을 수 없다. 원본을 공유하는 것이다. 인스턴스화를 못하니까 하나만 있다. 
//그러나 인스턴스화는 복제본을 여러개 만드는 것.
import java.util.Scanner; //import문은 클래스 앞에 존재해야한다.

public class ScannerExam1 {

  public static void main(String[] args) {
    // 생성자이든 메소드이든 파라미터의 갯수 혹은 타입은 반드시 지킴.
    System.out.println("0부터 9사이의 숫자를 입력하세요.");

    Scanner scanner = new Scanner(System.in);// 생성부의 파라미터 자리는 시스템의 입력장치정보.
    // Scanner의 파라미터안에는 System.in을 넣어줘야한다! 기억해줘~
    // nextLine();//에러가 뜬 이유는 인스턴스변수가 없기 때문이다. 닷연산자(.)를 사용하여 인스턴스변수를 표시한다.
    String user = scanner.nextLine();
    scanner.close(); // 사용하고나면 에러나지 않게끔 닫아주는 것이 좋음.
    // wrapper란 원시형 타입을 클래스급으로 만들어주는 것.
    // integer는 int의 wrapper이고 wrapper는 원시형을 객체 처럼 쓸 수 있게 해주는 것이다.
    // 원시형 변수는 참조형 타입과는 다르게 호출하면 값이 나오므로 간접참조 방식으로 사용할 수 없다.(원시형변수는 직접참조방식임 그러므로 값이
    // 호출됨.)
    // == 원시형 타입은 클래스가 아니니까 변수와 메소드를 가질 수 없다.
    // 참조형 타입은 간접참조 방식이므로 변수와 메소드를 가질 수 있다. 소유할 수 있다. 선언할 수 있다.
    int i_user = Integer.parseInt(user); // parseInt 메소드는 자바api에 있는 것. -> string을 넣고 int가 나오게하고 싶을때 사용!!
                                         // 사용법 : parseInt(string) : int
    System.out.println(user + 1);
    System.out.println(i_user + 1);

    // 상속을 받을 때는 나의 바로 위를 상속 받는것이 좋다.
    // ex) 할아버지 - 아빠 - 나 일때 '나'는 '아빠'를 상속받는 것이 가장 좋다.(누릴 수 있는 기능들이 가장 많기 때문이다.)

  }
}