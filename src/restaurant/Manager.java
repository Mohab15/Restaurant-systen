package restaurant;

import XML.Dish;
import XML.User;
import XML.XMLReader;
import reservedRestaurant.ReservedTable;
import reservedRestaurant.savedXMLLoader;

import java.util.List;

public class Manager extends ValidUser {

    public List<Dish> viewDishes() {
        List<Dish> dishes_list = XMLReader.dishes;
        return dishes_list;
    }

    public List<User> viewUsers() {
        List<User> users_list = XMLReader.users;
        return users_list;
    }

    public List<ReservedTable> viewReservations() {
        List<ReservedTable> reservedTables_list = savedXMLLoader.reservedTables;
        return reservedTables_list;
    }

    public double getTotalEarnings() {
        double total = 0;
        List<ReservedTable> reservedTables_list = savedXMLLoader.reservedTables;
        for (int i = 0; i < reservedTables_list.size(); i++)
            total += reservedTables_list.get(i).getPrice();
        return total;


    }


}
