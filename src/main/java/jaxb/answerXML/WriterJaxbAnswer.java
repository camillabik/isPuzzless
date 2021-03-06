package jaxb.answerXML;



import pojo.Answer;
import pojo.Question;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class WriterJaxbAnswer {
    private Answer answer;

    public WriterJaxbAnswer(Answer answer) {
        this.answer = answer;
    }

    public static void main(String[] args) throws JAXBException {

    }

    public static void writer(String puth) throws JAXBException {
        Answer answer = new Answer();

        File file = new File("C:\\Users\\admin\\IdeaProjects\\test1\\src\\puzzles\\jaxb\\answer.xml");
        JAXBContext context = JAXBContext.newInstance(Answer.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(answer, file);
        marshaller.marshal(answer, System.out);
    }
}
