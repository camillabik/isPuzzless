package jaxb.questionXml;


import pojo.Question;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.File;

public class WriterJaxbQuestion {
    private Question question;

    public WriterJaxbQuestion(Question question) {
        this.question = question;
    }


    public static void main(String[] args) throws JAXBException {
        writer("C:\\Users\\admin\\IdeaProjects\\test1\\src\\puzzles\\jaxb\\userXml\\questionXml\\question.xml");
    }

    public static void writer(String puth) throws JAXBException {
        File file = new File(puth);
        Question question = new Question();
        JAXBContext context = JAXBContext.newInstance(Question.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(question, file);
        marshaller.marshal(question, System.out);
    }

}
