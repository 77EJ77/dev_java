package main.java.dev_java.backup_1;

import java.util.ArrayList;
import java.util.List;

public class ChatListVO {
  private int no;
  private String chat_title;
  private int user_cnt;

  public int getNo() {
    return this.no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getChat_title() {
    return this.chat_title;
  }

  public void setChat_title(String chat_title) {
    this.chat_title = chat_title;
  }

  public int getUser_cnt() {
    return this.user_cnt;
  }

  public void setUser_cnt(int user_cnt) {
    this.user_cnt = user_cnt;
  }

  public static void main(String[] args) {
    ArrayList<ChatListVO> list = new ArrayList<>();
  }

}