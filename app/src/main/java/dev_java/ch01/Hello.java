package app.src.main.java.dev_java.ch01;

public class Hello {

    int methodA(int i, int j) {
        int hap;
        hap = i + j;
        return hap;
    }

    public static void main(String[] args) {
        System.out.println("git설정 추가");
        System.out.println("Hello Java!!!");

        Hello he = new Hello();
        he.methodA(1, 3);
    }

}
