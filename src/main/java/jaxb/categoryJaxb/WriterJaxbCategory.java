package jaxb.categoryJaxb;



import pojo.Answer;
import pojo.Category;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class WriterJaxbCategory {
    public static void main(String[] args) throws JAXBException {
        writer("C:\\Users\\admin\\IdeaProjects\\test1\\src\\puzzles\\jaxb\\answer.xml");

    }public static void writer(String puth) throws JAXBException {
        Category category = new Category();
        File file = new File(puth);
        JAXBContext context = JAXBContext.newInstance(Answer.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(category, file);
        marshaller.marshal(category, System.out);
    }
}
