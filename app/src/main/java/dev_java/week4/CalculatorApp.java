package dev_java.week4;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Calculate {

  public String calculate(Vector<String> vList) {
    System.out.println("계산 입장");
    String result = null;
    String res = "";
    int num;
    for (int i = 0; i < vList.size(); i++) {
      System.out.println("출력중 : " + vList.get(i));
      switch (vList.get(i)) {
        case "+":
          // while()
          System.out.println("case+ + : " + res + ", " + vList.get(i + 1));
          num = cal_plu(Integer.parseInt(res), Integer.parseInt(vList.get(i + 1)));
          res = num + "";
          return res;
        case "-":
          System.out.println("case- + : " + res + ", " + vList.get(i + 1));
          num = cal_min(Integer.parseInt(res), Integer.parseInt(vList.get(i + 1)));
          res = num + "";
          return res;
        case "*":
          System.out.println("case* + : " + res + ", " + vList.get(i + 1));
          num = cal_mul(Integer.parseInt(res), Integer.parseInt(vList.get(i + 1)));
          res = num + "";
          return res;
        case "/":
          System.out.println("case/ + : " + res + ", " + vList.get(i + 1));
          num = cal_div(Integer.parseInt(res), Integer.parseInt(vList.get(i + 1)));
          res = num + "";
          return res;
        default:
          res = res + vList.get(i);
      }
    }
    System.out.println("계산 퇴장 : " + result);
    return result;
  }

  public int cal_plu(int num, int result) {
    System.out.println("더하기 입장");
    // result += num;
    System.out.println("result : " + result);
    return num + result;
  }

  public int cal_min(int num, int result) {
    System.out.println("빼기 입장");
    // result -= num;
    System.out.println("result : " + result);
    return num - result;
  }

  public int cal_mul(int num, int result) {
    System.out.println("곱하기 입장");
    // result *= num;
    System.out.println("result : " + result);
    return num * result;
  }

  public int cal_div(int num, int result) {
    System.out.println("나누기 입장");
    // result /= num;
    System.out.println("result : " + result);
    return num / result;
  }
}

public class CalculatorApp extends JFrame implements ActionListener {
  // 선언부
  JTextField jtf = new JTextField(10);
  JPanel jp = new JPanel();
  JButton jbtn_clear = new JButton("C");
  JButton jbtn_equal = new JButton("=");
  JButton jbtn_one = new JButton("1");
  JButton jbtn_plus = new JButton("+");
  JButton jbtn_minus = new JButton("-");
  JButton jbtn_mult = new JButton("*");
  JButton jbtn_div = new JButton("/");
  JButton jbtn_two = new JButton("2");
  Font f = new Font("Paryrus", Font.BOLD, 40);
  String str;
  Vector<String> vList = new Vector<>();
  Calculate cc = new Calculate();

  // 생성부
  public CalculatorApp() {
    initDisplay();
  }

  // 화면처리기
  public void initDisplay() {
    jp.setBackground(Color.LIGHT_GRAY);
    jp.setLayout(new GridLayout(2, 6, 2, 2));
    jbtn_one.setFont(f);
    jbtn_two.setFont(f);
    jbtn_plus.setFont(f);
    jbtn_minus.setFont(f);
    jbtn_mult.setFont(f);
    jbtn_div.setFont(f);
    jbtn_equal.setFont(f);
    jbtn_clear.setFont(f);
    jbtn_one.addActionListener(this);
    jbtn_two.addActionListener(this);
    jbtn_plus.addActionListener(this);
    jbtn_minus.addActionListener(this);
    jbtn_mult.addActionListener(this);
    jbtn_div.addActionListener(this);
    jbtn_equal.addActionListener(this);
    jbtn_clear.addActionListener(this);
    jp.add(jbtn_plus);
    jp.add(jbtn_minus);
    jp.add(jbtn_mult);
    jp.add(jbtn_div);
    jp.add(jbtn_equal);
    jp.add(jbtn_clear);
    jp.add(jbtn_one);
    jp.add(jbtn_two);
    jtf.setEditable(false);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.add("North", jtf);
    this.add("Center", jp);
    this.setTitle("내가 만든 계산기");
    this.setSize(500, 300);
    this.setVisible(true);
  }

  public static void main(String[] args) {
    new CalculatorApp();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object ob = e.getSource();
    if (ob == jbtn_one) {
      vList.add("1");
      str = jtf.getText() + "1";
      jtf.setText(str);
      if (vList.size() != 1) {
        jtf.setText(cc.calculate(vList));
      }
    } else if (ob == jbtn_two) {
      vList.add("2");
      str = jtf.getText() + "2";
      jtf.setText(str);
      if (vList.size() != 1) {
        jtf.setText(cc.calculate(vList));
      }
    } else if (ob == jbtn_plus) {
      vList.add("+");
      str = jtf.getText() + "+";
      jtf.setText(str);
    } else if (ob == jbtn_minus) {
      vList.add("-");
      str = jtf.getText() + "-";
      jtf.setText(str);
    } else if (ob == jbtn_mult) {
      vList.add("*");
      str = jtf.getText() + "*";
      jtf.setText(str);
    } else if (ob == jbtn_div) {
      vList.add("/");
      str = jtf.getText() + "/";
      jtf.setText(str);
    } else if (ob == jbtn_equal) {
      str = jtf.getText();
      if (vList.size() != 0) {
        jtf.setText(cc.calculate(vList));
      }
    } else if (ob == jbtn_clear) {
      vList = new Vector<>();
      jtf.setText("");
    }
  }
}
