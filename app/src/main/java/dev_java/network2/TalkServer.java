package dev_java.network2;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//선언과 생성을 분리하는 코딩전개
//자바는 단일상속만 가능함
//자바는 단일상속의 단점을 보완하기위해 인터페이스는 다중으로 처리가능함
public class TalkServer extends JFrame implements Runnable, ActionListener { // 메인스레드와 경합이 벌어지기 때문에 runnable을 넣음
  // 선언부
  // 클라이언트 측에서 new Socket하면 그 소켓정보를 받아서 쓰레드로 넘김
  TalkServerThread tst = null;
  // 동시에 여러명이 접속하니까 List - Vector<>(); 멀티스레드 안전, 속도 느림.
  List<TalkServerThread> globalList = null;
  ServerSocket server = null;
  Socket socket = null;
  JTextArea jta_log = new JTextArea(10, 30);
  JScrollPane jsp_log = new JScrollPane(jta_log, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  JButton jbtn_log = new JButton("로그저장");

  public TalkServer() {
    // initDisplay();// 이렇게 하면 망한다 - 시점의 문제 발생 - 스케줄링을 해야 함
  }

  // 화면 그리기
  public void initDisplay() {
    jbtn_log.addActionListener(this);
    this.add("North", jbtn_log);
    this.add("Center", jsp_log);
    this.setSize(500, 400);
    this.setVisible(true);
  }

  public static void main(String[] args) {// 엔트리포인트 - 메인메소드 자체도 메인스레드
    TalkServer ts = new TalkServer();
    ts.initDisplay();// 스레드보다 이게 먼저 나와야함
    Thread th = new Thread(ts); // TalkServer를 먼저 생성하고있기 때문에 ts를 넘겨줘야함 협업을 위해
    th.start();
  }

  // 서버소켓과 클라이언트측 소켓을 연결하기
  @Override
  public void run() {
    // 서버에 접속해온 클라이언트 스레드 정보를 관리할 벡터 생성하기
    globalList = new Vector<>();// 멀티스레드 안전해서 ArrayList 대신 사용함
    boolean isStop = false;
    try {
      server = new ServerSocket(3000);// 서버 포트번호 설정하기
      jta_log.append("Server Ready.........\n");// 대기탐 - 멈춤 - wait
      while (!isStop) {
        socket = server.accept();
        jta_log.append("client info:" + socket + "\n");
        jta_log.append("client info:" + socket.getInetAddress() + "\n");
        TalkServerThread tst = new TalkServerThread(this);
        tst.start();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }///////////////////////////////// end of run /////////////////////////////////

  @Override
  public void actionPerformed(ActionEvent e) {
    // 로그를 파일로 저장하기 -> 여기서 하면 어떨까요
  }
}
