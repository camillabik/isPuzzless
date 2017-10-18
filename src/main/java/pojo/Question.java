package pojo;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Question {
   private int id;
   private Category category;
   private String name;
   private String text;
   private String pathToPictureQuestion;


   public Question(int id) {
      this.id = id;
   }

   public Question(Category category) {
      this.category = category;

   }

   public Question(int id, Category category, String name, String text) {
      this.category = category;
      this.id = id;
      this.name = name;
      this.text = text;
   }

   public Question(Category category,String name,int id,String pathToPictureQuestion) {
      this.category = category;
      this.id = id;
      this.name = name;
      this.pathToPictureQuestion = pathToPictureQuestion;
   }

   public Question(Category category, String name, String text) {
      this.category = category;
      this.name = name;
      this.text = text;
   }


   public Category getCategory() {
      return category;
   }
   @XmlElement
   public void setCategory(Category category) {
      this.category = category;
   }

   public int getId() {
      return id;
   }
   @XmlElement
   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }
   @XmlElement
   public void setName(String name) {
      this.name = name;
   }

   public String getText() {
      return text;
   }
   @XmlElement
   public void setPathToTextQuestion(String text) {
      this.text = text;
   }

   public String getPathToPictureQuestion() {
      return pathToPictureQuestion;
   }

   public void setPathToPictureQuestion(String pathToPictureQuestion) {
      this.pathToPictureQuestion = pathToPictureQuestion;
   }

   @Override
   public String toString() {
      return "Question{" +
              "category=" + category +
              ", name='" + name + '\'' +
              ", text='" + text + '\'' +
              '}';
   }
}
