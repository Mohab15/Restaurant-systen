package reservedRestaurant;


import restaurant.Order;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLSaver {

    public void save(Order order) throws Exception {
        List<ReservedTable> reservedtables_list = savedXMLLoader.reservedTables;

        JAXBContext jaxbContext = JAXBContext.newInstance(ReservedRestaurant.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        ReservedRestaurant reservedRestaurant = new ReservedRestaurant();

        ReservedTables reservedTables = new ReservedTables();
        ReservedTable reservedTable = new ReservedTable();

        reservedTable.setName(order.getName());
        reservedTable.setNumber(order.getTableNumber());
        reservedTable.setPrice(order.getPrice());
        reservedTable.setOrder(order.getOrder());

        List<ReservedTable> tableList = new ArrayList<>();
        reservedtables_list.add(reservedTable);
        reservedTables.setReservedTables(reservedtables_list);


        reservedRestaurant.setReservedTables(reservedTables);

        marshaller.marshal(reservedRestaurant, new File("saved.xml"));
    }

}
