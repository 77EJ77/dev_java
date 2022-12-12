package dev_java1.sungjuk;

public class StudentVO {
   private String name;
   private String subjects[] = {"Java", "Oracle","Spring"};

	public String[] getSubjects() {
		return this.subjects;
	}

	public void setSubjects(String subjects[]) {
		this.subjects = subjects;
	}

   private int tot;
   private double avg;

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getTot() {
      return this.tot;
   }

   public void setTot(int tot) {
      this.tot = tot;
   }

   public double getAvg() {
      return this.avg;
   }

   public void setAvg(double avg) {
      this.avg = avg;
   }

   public class GradeVO{
      private int scoreJava;
      private int scoreOracle;
      private int scoreSpring;

      public int getScoreJava() {
         return this.scoreJava;
      }

      public void setScoreJava(int scoreJava) {
         this.scoreJava = scoreJava;
      }

      public int getScoreOracle() {
         return this.scoreOracle;
      }

      public void setScoreOracle(int scoreOracle) {
         this.scoreOracle = scoreOracle;
      }

      public int getScoreSpring() {
         return this.scoreSpring;
      }

      public void setScoreSpring(int scoreSpring) {
         this.scoreSpring = scoreSpring;
      }

   }
}
