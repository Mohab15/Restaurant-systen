package reservedRestaurant;

import XML.XMLReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class savedXMLLoader {
    public static List<ReservedTable> reservedTables;

    public savedXMLLoader() throws Exception {

        JAXBContext jaxbContext = JAXBContext.newInstance(ReservedRestaurant.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        ReservedRestaurant reservedRestaurant = (ReservedRestaurant) unmarshaller.unmarshal(new File("saved.xml"));

        this.reservedTables = reservedRestaurant.getReservedTables().getReservedTables();
    }
}
