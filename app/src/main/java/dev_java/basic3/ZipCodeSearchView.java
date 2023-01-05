package dev_java.basic3;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dev_java.util.DBConnectionMgr;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ZipCodeSearchView extends JFrame implements ItemListener {
  // 선언부
  // 사용자가 선택한 zdo
  String zdo = null;
  // 사용자가 선택한 sigu
  String sigu = null;
  // 사용자가 선택한 dong
  String dong = null;
  // DB에서 가져온 zdos[]
  String zdoz[] = null;
  // DB에서 가져온 sigu[]
  String sigus[] = null;
  // DB에서 가져온 dong[]
  String dongs[] = null;

  String totals[] = new String[] { "전체" };

  JPanel jp_north = new JPanel();
  JComboBox com_zdo = null;
  JComboBox com_sigu = null;
  JComboBox com_dong = null;
  DBConnectionMgr mgr = new DBConnectionMgr();
  Connection con = null;
  PreparedStatement pst = null;
  ResultSet rs = null;
  // 테이블 생성
  String[] cols = { "우편번호", "주소" };
  String[][] data = new String[3][3];
  DefaultTableModel dtm_zip = new DefaultTableModel(data, cols);
  JTable jtb = new JTable(dtm_zip);
  JTableHeader jth = jtb.getTableHeader();
  JScrollPane jsp_zip = new JScrollPane(jtb, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

  // 생성자
  public ZipCodeSearchView() { // 게으른 인스턴스화 -> DB의 데이터값 가져오기위해 어쩔 수 없
    zdoz = getZDOList();
    com_zdo = new JComboBox(zdoz);
    com_zdo.addItemListener(this);
    com_sigu = new JComboBox(totals);
    com_sigu.addItemListener(this);
    com_dong = new JComboBox(totals);
    com_dong.addItemListener(this);
  }

  // 대분류 정보 초기화에 필요한 DB조회하기 구현
  public String[] getZDOList() {
    StringBuilder sql = new StringBuilder();
    sql.append(
        "SELECT '전체' zdo FROM dual UNION ALL SELECT zdo FROM (SELECT distinct(zdo) FROM zipcode_t order by zdo asc)");
    // sql.append("select '전체' zdo from dual ");
    // sql.append("union all ");
    // sql.append("select zdo ");
    // sql.append("from ( ");
    // sql.append("select distinct(zdo) zdo ");
    // sql.append("from zipcode_t ");
    // sql.append("order by zdo asc) ");
    try {
      // con의 주소가 확인되면 오라클 서버와 연결통로가 확보되었다.
      con = mgr.getConnection();
      pst = con.prepareStatement(sql.toString());
      // 오라클에서 생성된 테이블의 커서 디폴트 위치는 항상 isTop이다
      Vector<String> v = new Vector<>();
      rs = pst.executeQuery();
      while (rs.next()) {
        String vivi = rs.getString("zdo");
        v.add(vivi);
      }
      zdoz = new String[v.size()];
      v.copyInto(zdoz);
    } catch (SQLException se) {
      se.printStackTrace();
      System.out.println(se.toString());// getMessage()
      System.out.println(sql.toString());
    } catch (Exception e) {
      e.printStackTrace();
    } finally { // 사용한 자원 반납하기 - 생성된 역순으로 할 것
      // 생략해도 언젠간 반납이 이뤄짐 - 명시적으로 반납처리 권장
      // 왜냐하면 오라클 서버에서 커넥션을 강제로 종료시켜 버리니까
      try {
        mgr.freeConnection(con, pst, rs);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return zdoz;
  }

  public String[] getSIGUList(String zdo) {
    StringBuilder sql = new StringBuilder();
    sql.append(
        "SELECT '전체' sigu FROM dual UNION ALL SELECT sigu FROM ( SELECT distinct(sigu) FROM zipcode_t where zdo=? order by sigu asc )");
    try {
      con = mgr.getConnection();
      pst = con.prepareStatement(sql.toString());
      pst.setString(1, zdo);
      Vector<String> v = new Vector<>();
      rs = pst.executeQuery();
      while (rs.next()) {
        String vivi = rs.getString("sigu");
        v.add(vivi);
      }
      sigus = new String[v.size()];
      v.copyInto(sigus);
    } catch (SQLException se) {
      se.printStackTrace();
      System.out.println(se.toString());
      System.out.println(sql.toString());
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        mgr.freeConnection(con, pst, rs);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return sigus;
  }

  private String[] getDONGList(String zdo, String sigu) {
    StringBuilder sql = new StringBuilder();
    sql.append(
        "SELECT '전체' dong FROM dual UNION ALL SELECT dong FROM ( SELECT distinct(dong) FROM zipcode_t where zdo=? and sigu=? order by dong asc )");
    try {
      con = mgr.getConnection();
      pst = con.prepareStatement(sql.toString());
      pst.setString(1, zdo);
      pst.setString(2, sigu);
      Vector<String> v = new Vector<>();
      rs = pst.executeQuery();
      while (rs.next()) {
        String vivi = rs.getString("dong");
        v.add(vivi);
      }
      dongs = new String[v.size()];
      v.copyInto(dongs);
    } catch (SQLException se) {
      se.printStackTrace();
      System.out.println(se.toString());
      System.out.println(sql.toString());
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        mgr.freeConnection(con, pst, rs);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return dongs;
  }

  // 화면처리부
  public void initDisplay() {
    jth.setBackground(Color.LIGHT_GRAY);
    jth.setFont(new Font("맑은고딕", Font.BOLD, 20));
    jtb.getColumnModel().getColumn(0).setPreferredWidth(100);// 간격 - 우편번호
    jtb.getColumnModel().getColumn(1).setPreferredWidth(300);// 간격 - 주소
    // 그리드 색상 - 블랙
    jtb.setGridColor(Color.BLACK);
    // 윈도우창 닫기 버튼 - 자원 회수하기
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jp_north.add(com_zdo);
    jp_north.add(com_sigu);
    jp_north.add(com_dong);
    this.add("North", jp_north);
    this.add("Center", jsp_zip);
    this.setSize(630, 400);
    this.setVisible(true);
  }

  // 메인메소드
  public static void main(String[] args) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    ZipCodeSearchView zv = new ZipCodeSearchView();
    zv.initDisplay();
  }

  @Override
  public void itemStateChanged(ItemEvent ie) {
    // 이벤트가 감지되는 소스 가져오기
    Object obj = ie.getSource();
    // 콤보박스 여부 확인
    if (obj == com_zdo) {
      if (ie.getStateChange() == ItemEvent.SELECTED) {
        System.out.println("선택한 지도 : " + zdoz[com_zdo.getSelectedIndex()]);
        zdo = zdoz[com_zdo.getSelectedIndex()];
        sigus = getSIGUList(zdo);
        // 대분류가 결정이 되었을 때 sigus를 초기화해줘야 함
        // 기존에 디폴트로 전체 상수값을 넣어두었으니 이것을 삭제하고 새로 DB서버에서 읽어온 값으로 아이템을 추가해야함 - 초기화
        com_sigu.removeAllItems();
        for (int i = 0; i < sigus.length; i++) {
          com_sigu.addItem(sigus[i]);
        }
      }
    } else if (obj == com_sigu) {
      if (ie.getStateChange() == ItemEvent.SELECTED) {
        sigu = sigus[com_sigu.getSelectedIndex()];
        dongs = getDONGList(zdo, sigu);
        System.out.println(zdo + ", " + sigu + ", " + dongs.toString());
        // 대분류가 결정이 되었을 때 sigus를 초기화해줘야 함
        // 기존에 디폴트로 전체 상수값을 넣어두었으니 이것을 삭제하고 새로 DB서버에서 읽어온 값으로 아이템을 추가해야함 - 초기화
        com_dong.removeAllItems();
        for (int i = 0; i < dongs.length; i++) {
          com_dong.addItem(dongs[i]);
        }
      }
    }
  }

}
