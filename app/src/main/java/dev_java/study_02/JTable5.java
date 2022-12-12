package dev_java1.table1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

public class JTable5 extends JFrame implements ActionListener {
   // 선언부
   String header[] = { "부서번호", "부서명", "지역" };
   String data[][] = new String[1][3];
   String[][] depts = { { "10", "개발부", "서울" }, { "20", "운영부", "인천" }, { "30", "인사부", "대전" } };
   DefaultTableModel dtm = new DefaultTableModel(data, header);
   JTable jtb = new JTable(dtm);
   JScrollPane jsp = new JScrollPane(jtb, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
         JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
   JPanel jp_north = new JPanel();
   JButton jbtn_search = new JButton("조회");
   JButton jbtn_add = new JButton("입력");
   JButton jbtn_del = new JButton("삭제");
   JButton jbtn_exit = new JButton("종료");

   // 생성자
   public JTable5() {
      jbtn_search.addActionListener(this);
      jbtn_add.addActionListener(this);
      jbtn_del.addActionListener(this);
      jbtn_exit.addActionListener(this);
      initDisplay();
   }

   // 화면그리기
   public void initDisplay() {
      /*
       * jtb.addMouseListener(new MouseAdapter() { public void mouseClicked(MouseEvent
       * me) { if (me.getClickCount() >= 2) { System.out.println("데이타 더블클릭"); } } });
       */
      jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
      jp_north.add(jbtn_search);
      jp_north.add(jbtn_add);
      jp_north.add(jbtn_del);
      jp_north.add(jbtn_exit);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.add("North", jp_north);
      this.add("Center", jsp);
      this.setTitle("부서관리 -[조회구현]");
      this.setSize(500, 400);
      this.setVisible(true);
   }

   // 메인메소드
   public static void main(String[] args) {
      new JTable5();
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      Object obj = e.getSource();
      if (jbtn_search == obj) {
         System.out.println("조회 버튼 클릭");
         // 이미 테이블에 조회된 정보가 있는 경우 모두 삭제하기
         System.out.println("detm.getRowCount : " + dtm.getRowCount());
         while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
         }
         int a = 0;
         int b = 0;
         for (int i = 0; i < depts.length; i++) {
            for (int j = 0; j < depts[i].length; j++) {
               a = i + 1;
               b = j;
               System.out.print("a:" + a + ", b:" + b + "=>" + depts[i][j] + "  ");
               // dtm.setValueAt(data[i][j], a, b);
            }
            System.out.println();
         }
         for (int i = 0; i < depts.length; i++) {
            Vector<Object> oneRow = new Vector<>();
            oneRow.add(depts[i][0]);
            oneRow.add(depts[i][1]);
            oneRow.add(depts[i][2]);
            dtm.addRow(oneRow);
         }
      } else if (jbtn_add == obj) {
         System.out.println("입력 버튼 클릭");
      } else if (jbtn_del == obj) {
         System.out.println("삭제 버튼 클릭");
         int index = jtb.getSelectedRow();
         // System.out.println("선택한 index : " + index);
         Integer deptno = Integer.parseInt(dtm.getValueAt(index, 0).toString());
         System.out.println("사용자가 선택한 부서번호 : " + deptno);
         while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
         }         

         for (int i = 0; i < depts.length; i++) {
            if(index == i){
               //depts2 = Arrays.copyOf(depts, index);
               //System.out.println(Arrays.toString(depts2));
               continue;
            }
            Vector<Object> oneRow = new Vector<>();
            oneRow.add(depts[i][0]);
            oneRow.add(depts[i][1]);
            oneRow.add(depts[i][2]);
            dtm.addRow(oneRow);
         }         
      } else if (jbtn_exit == obj) {
         System.out.println("종료 버튼 클릭");
      }
   }
}
