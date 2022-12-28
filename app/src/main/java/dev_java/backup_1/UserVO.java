package main.java.dev_java.backup_1;

public class UserVO {
  private String id;
  private String password;
  private String name;
  private String nickname;
  private String hp;
  private String mail;
  private String stat;

  public UserVO() {

  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNickname() {
    return this.nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getHp() {
    return this.hp;
  }

  public void setHp(String hp) {
    this.hp = hp;
  }

  public String getMail() {
    return this.mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getStat() {
    return this.stat;
  }

  public void setStat(String stat) {
    this.stat = stat;
  }

  @Override
  public String toString() {
    return super.toString();
  }

}
