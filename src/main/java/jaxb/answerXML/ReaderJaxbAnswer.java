package jaxb.answerXML;




import pojo.Answer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ReaderJaxbAnswer {
    private Answer answer;

    public ReaderJaxbAnswer(Answer answer) {
        this.answer = answer;
    }

    public static void main(String[] args) throws JAXBException {
     reader("C:\\Users\\admin\\IdeaProjects\\test1\\src\\puzzles\\jaxb\\answer.xml");
    }

    public static void reader(String puth) throws JAXBException {
        File file = new File(puth);
        JAXBContext jaxbContext = JAXBContext.newInstance(Answer.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Answer answer = (Answer) jaxbUnmarshaller.unmarshal(file);
        System.out.println(answer.getAnswer());
        System.out.println(answer.getQuestion());
        System.out.println(answer.isRightAnswer());
    }


}
