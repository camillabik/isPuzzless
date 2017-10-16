package jaxb.userJaxb;



import pojo.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;


public class WriterJaxbUser {
    private User user;

    public WriterJaxbUser(User user) {
        this.user = user;
    }


    public static void main(String[] args) throws JAXBException {
        writer("C:\\Users\\admin\\IdeaProjects\\test1\\src\\puzzles\\jaxb\\user.xml");
    }
    public static void writer(String puth) throws JAXBException
    {
        User user = new User();

        File file = new File(puth);
        JAXBContext context = JAXBContext.newInstance(User.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(user, file);
        marshaller.marshal(user, System.out);
    }

}
