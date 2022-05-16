package restaurant;


import reservedRestaurant.ReservedTable;
import reservedRestaurant.savedXMLLoader;

import java.util.List;

public class Waiter extends ValidUser {

    public List<ReservedTable> viewReservations() {
        List<ReservedTable> reservedTables_list = savedXMLLoader.reservedTables;
        return reservedTables_list;
    }


}
