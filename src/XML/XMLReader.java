package XML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class XMLReader {
    public static List<User> users;
    public static List<Table> tables;
    public static List<Dish> dishes;

    public XMLReader() throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Restaurant.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Restaurant restaurant = (Restaurant) unmarshaller.unmarshal(new File("Restaurant.xml"));

        this.users = restaurant.getUsers().getUsers();
        this.tables = restaurant.getTables().getTables();
        this.dishes = restaurant.getDishes().getDishes();

    }


}
