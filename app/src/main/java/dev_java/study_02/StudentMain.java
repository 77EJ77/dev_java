package dev_java.study_02;

import dev_java.study_02.StudentVO.GradeVO;

public class StudentMain {
   static int index = 0;
   StudentVO[] sVOs = new StudentVO[3];

   public void add(StudentVO sVO) {
      sVOs[index] = sVO;
      index++;
   }

   public void studentList() {
      System.out.println("studentList 호출 : " + sVOs.length);
      for (int i = 0; i < sVOs.length; i++) {
         StudentVO sVO = sVOs[i];
         System.out.println(sVO.getName() + " : 총점은 " + sVO.getTot() + ", 평균은 " + sVO.getAvg());
      }
   }

   public static void main(String[] args) {
      StudentVO sVO = new StudentVO();
      sVO.setName("이순신");
      sVO.setTot(0);
      sVO.setAvg(0.0);
      GradeVO gVO = sVO.new GradeVO();

      gVO.setScoreJava(80);
      gVO.setScoreOracle(85);
      gVO.setScoreSpring(90);

      sVO.setTot(gVO.getScoreJava() + gVO.getScoreOracle() + gVO.getScoreSpring());
      sVO.setAvg(sVO.getTot() / 3.0);

      // System.out.println(sVO.getName()+" : 총점은 "+sVO.getTot()+", 평균은
      // "+sVO.getAvg());

      StudentMain sm = new StudentMain();
      sm.add(sVO);

      sVO = new StudentVO();
      sVO.setName("강감찬");
      sVO.setTot(0);
      sVO.setAvg(0.0);
      gVO = sVO.new GradeVO();

      gVO.setScoreJava(90);
      gVO.setScoreOracle(95);
      gVO.setScoreSpring(90);

      sVO.setTot(gVO.getScoreJava() + gVO.getScoreOracle() + gVO.getScoreSpring());
      sVO.setAvg(sVO.getTot() / 3.0);
      sm.add(sVO);

      sVO = new StudentVO();
      sVO.setName("김춘추");
      sVO.setTot(0);
      sVO.setAvg(0.0);
      gVO = sVO.new GradeVO();

      gVO.setScoreJava(60);
      gVO.setScoreOracle(65);
      gVO.setScoreSpring(60);

      sVO.setTot(gVO.getScoreJava() + gVO.getScoreOracle() + gVO.getScoreSpring());
      sVO.setAvg(sVO.getTot() / 3.0);
      sm.add(sVO);

      sm.studentList();

   }
}