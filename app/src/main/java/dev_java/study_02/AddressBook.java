package dev_java.study_02;

// import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
// import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;
import java.util.Vector;

public class AddressBook implements ActionListener {
  // 선언부
  JFrame jf = new JFrame();

  // 이미지 경로 선언
  String imgPath = "D:\\vscode_java\\dev_java\\images\\address\\";
  // 툴바 및 타이틀 이미지 설정
  ImageIcon ticon = new ImageIcon(imgPath + "memo.png");
  JToolBar jtb = new JToolBar();

  // 메뉴바 구성하기
  JMenuBar jmb = new JMenuBar();
  JMenu jm_file = new JMenu("File");
  JMenuItem jmi_db = new JMenuItem("DB 연동 확인");
  JMenuItem jmi_all = new JMenuItem("전체 조회");
  JSeparator js_exit = new JSeparator();
  JMenuItem jmi_exit = new JMenuItem("종료");
  JMenu jm_edit = new JMenu("Edit");
  JMenuItem jmi_ins = new JMenuItem("입력");
  JMenuItem jmi_upd = new JMenuItem("수정");
  JMenuItem jmi_del = new JMenuItem("삭제");
  JMenuItem jmi_read = new JMenuItem("상세보기");

  // JPanel jp = new JPanel();
  // String[] jb_label = new String[] { "전체조회", "입력", "수정", "상세보기" };
  // JButton[] jbtn = new JButton[4];
  JButton jbtn_del = new JButton();
  JButton jbtn_ins = new JButton();
  JButton jbtn_upd = new JButton();
  JButton jbtn_read = new JButton();
  // ▽ BorderLayout 중앙에 테이블(주소록 목록) 추가하기.
  // JTable Header에 들어갈 문자열 선언
  String header[] = { "번호", "이름", "H.P" };
  // JTable은 양식만 제공할 뿐이고 데이터를 담을 클래스는 별도로 필요함
  String datas[][] = new String[3][3];
  // JTable에 들어갈 실제 데이터셋을 관리할 수 있는 클래스 선언함
  // JTable에 보여지는 실제 데이터는 DefaultTableModel클래스를 통해 제어해야 함을 의미
  DefaultTableModel dtm = new DefaultTableModel(datas, header);
  // 데이터 셋을 JTable생성시 파라미터로 매칭하기
  JTable jt = new JTable(dtm);// dtm이 Data_set
  // DefaultTableModel의 로우수가 많아지는 경우 스크롤바 추가해야 함
  JScrollPane jsp = new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

  AddressDialog aDialog = new AddressDialog();

  // 생성자
  public AddressBook() {
    initDisPlay();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == jmi_all/* jbtn[0] */) { // 전체 조회 - 검색
      String members[][] = {
          { "1", "가나다", "010-1234-5678" },
          { "2", "마바사", "010-9123-4567" },
          { "3", "아자차", "010-8912-3456" }
      };
      // dtm.setDataVector(members, header);
      // 이미 테이블에 조회된 정보가 있는 경우 모두 삭제함
      while (dtm.getRowCount() > 0) {
        dtm.removeRow(0);
      }
      for (int i = 0; i < members.length; i++) {
        Vector<String> oneRow = new Vector<>();// <제네릭> <- 꺾쇠?
        for (int j = 0; j < members[i].length; j++) {
          oneRow.add(members[i][j]);
        }
        dtm.addRow(oneRow);
      }
      // jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
      // 익명 클래스 문법 사용 - 자바 람다식, 자바스크립트 Arrow Function문법과 유사
      jsp.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
        @Override
        public void adjustmentValueChanged(AdjustmentEvent e) {
          JScrollBar jsb = (JScrollBar) e.getSource();
          jsb.setValue(jsb.getMaximum());
        }
      });

    } else if (obj == jbtn_ins/* jbtn[1] */) { // 입력
      // aDialog.setDialog("입력"/* jb_label[1] */, true);
      aDialog.setDialog(jmi_ins.getText()/* jb_label[1] */, true);
    } else if (obj == jbtn_upd/* jbtn[2] */) { // 수정
      aDialog.setDialog("수정"/* jb_label[2] */, true);
    } else if (obj == jbtn_read/* jbtn[3] */) { // 상세보기
      aDialog.setDialog("상세보기"/* jb_label[3] */, true);
    } else if (obj == jmi_exit) {
      System.exit(0);// 자원을 회수하고 candidate?값으로 빼버림 -> 쓰레기 값으로 뺌. -> thread에는 우선순위가 있음.
    }
  }

  public void initDisPlay() {
    jm_file.setMnemonic('F');// ?
    jm_edit.setMnemonic('E');
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setSize(500, 450);
    jf.setTitle("주소록 Ver1.0");
    // // JPanel은 FlowLayout이 기본값인데 사용자 정의 크기와 위치를 위해 레이아웃을 뭉갠다.
    // // setLayout으로 Null값을 줘서 뭉갬. 그리고 좌표를 직접 입력해 붙이는 방법을 쓴다고 함.
    // jp.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
    // jp.setLayout(null);
    // for (int i = 0; i < jbtn.length; i++) {
    // jbtn[i] = new JButton(jb_label[i]);
    // // jbtn[i].setBounds(20, 20, 120, 30);
    // jp.add(jbtn[i]);
    // jbtn[i].addActionListener(this);// *** // 이벤트소스와 이벤트 핸들러 클래스 매칭
    // }
    jtb.add(jbtn_ins);
    jbtn_ins.addActionListener(this);
    jbtn_ins.setIcon(new ImageIcon(imgPath + "new.gif"));
    jtb.add(jbtn_upd);
    jbtn_upd.addActionListener(this);
    jbtn_upd.setIcon(new ImageIcon(imgPath + "update.gif"));
    jbtn_upd.setToolTipText("수정");// ->도움말 추가
    jtb.add(jbtn_del);
    jbtn_del.addActionListener(this);
    jbtn_del.setIcon(new ImageIcon(imgPath + "delete.gif"));
    jtb.add(jbtn_read);
    jbtn_read.addActionListener(this);
    jbtn_read.setIcon(new ImageIcon(imgPath + "detail.gif"));
    // jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());

    jm_file.add(jmi_db);
    jm_file.add(jmi_all);
    jm_file.add(js_exit);
    jm_file.add(jmi_exit);
    jmb.add(jm_file);
    jm_edit.add(jmi_ins);
    jm_edit.add(jmi_upd);
    jm_edit.add(jmi_del);
    jm_edit.add(jmi_read);
    jmb.add(jm_edit);
    jf.setJMenuBar(jmb);

    // jf.add("North", jp);
    jf.add("North", jtb);
    jf.add("Center", jsp);
    jf.setVisible(true);
  }

  public static void main(String[] args) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    new AddressBook();
  }
}
