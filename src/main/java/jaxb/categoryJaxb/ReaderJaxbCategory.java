package jaxb.categoryJaxb;


import pojo.Answer;
import pojo.Category;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ReaderJaxbCategory {
    private Category category;

    public ReaderJaxbCategory(Category category) {
        this.category = category;
    }
    public static void main(String[] args) throws JAXBException {
        reader("C:\\Users\\admin\\IdeaProjects\\test1\\src\\puzzles\\jaxb\\category.xml");
    }
    public static void reader(String puth) throws JAXBException {
        File file = new File(puth);
        JAXBContext jaxbContext = JAXBContext.newInstance(Answer.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Category category = (Category) jaxbUnmarshaller.unmarshal(file);
        System.out.println(category.getName());
    }


}
