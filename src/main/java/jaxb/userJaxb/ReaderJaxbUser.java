package jaxb.userJaxb;


import pojo.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ReaderJaxbUser {
    private User user;

    public ReaderJaxbUser(User user) {
        this.user = user;
    }

    public static void main(String[] args) throws JAXBException {
        reader("C:\\Users\\admin\\IdeaProjects\\test1\\src\\puzzles\\jaxb\\user.xml");
    }
    public static void reader(String puth)throws JAXBException
    {
        File file = new File(puth);
        JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        User user = (User) jaxbUnmarshaller.unmarshal(file);
        System.out.println(user.getLogin());
        System.out.println(user.getName());
    }

}
