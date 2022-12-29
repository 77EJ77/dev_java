package dev_java.week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TomcatServer {
  public static void main(String[] args) {
    String url = "http://192.168.10.68:9000/index.html";
    try {
      // 예외가 발생한 가능성이 있는 코드
      URL my = new URL(url);
      HttpURLConnection con = (HttpURLConnection) my.openConnection();
      int responseCode = con.getResponseCode(); // 200, 204, 404, 500...
      // System.out.println(responseCode);
      // System.out.println(5 / 0);

      BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));// 글자 깨지지않게 인코딩 설정
      StringBuilder sb = new StringBuilder();
      String line = "";// nullpointerexception 방지하기 위해 빈 문자열로 설정
      while ((line = br.readLine()) != null) {
        sb.append(line);
      }
      System.out.println(sb.toString());
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }
}
