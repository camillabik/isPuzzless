package pojo;

public class Answer {
   private int id;
   private Question question;
   private String answer;
   private boolean isRightAnswer;

   public Answer() {
   }

   public Answer(int id, Question question, String answer, boolean isRightAnswer) {
      this.id = id;
      this.question = question;
      this.answer = answer;
      this.isRightAnswer = isRightAnswer;
   }


   public Question getQuestion() {
      return question;
   }

   public void setQuestion(Question question) {
      this.question = question;
   }

   public String getAnswer() {
      return answer;
   }

   public void setAnswer(String answer) {
      this.answer = answer;
   }

   public boolean isRightAnswer() {
      return isRightAnswer;
   }

   public void setRightAnswer(boolean rightAnswer) {
      isRightAnswer = rightAnswer;
   }

   @Override
   public String toString() {
      return "Answer{" +
              "question=" + question +
              ", answer='" + answer + '\'' +
              ", isRightAnswer=" + isRightAnswer +
              '}';
   }
}
