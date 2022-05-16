package restaurant;

import XML.Dish;
import XML.Table;
import XML.XMLReader;
import reservedRestaurant.ReservedTable;
import reservedRestaurant.savedXMLLoader;

import java.util.List;

public class Client extends ValidUser {

    public List<Dish> viewDishes() {
        List<Dish> dishes_list = XMLReader.dishes;
        return dishes_list;
    }

    public List<Table> viewTables() {
        List<Table> tables_list = XMLReader.tables;
        return tables_list;
    }

    public double getCheck(Dish[] myDishes, int count) {
        double check = 0, sumAppetizers = 0, sumMainCourses = 0, sumDesserts = 0;
        for (int i = 0; i < count; i++) {
            if (myDishes[i].getType().equals("appetizer"))
                sumAppetizers += myDishes[i].getPrice() * 1.0;
            else if (myDishes[i].getType().equals("main_course"))
                sumMainCourses += myDishes[i].getPrice() * 1.0;
            else if (myDishes[i].getType().equals("desert"))
                sumDesserts += myDishes[i].getPrice() * 1.0;
        }
        sumAppetizers += sumAppetizers * 0.1;
        sumMainCourses += sumMainCourses * 0.15;
        sumDesserts += sumDesserts * 0.2;

        check = sumAppetizers + sumMainCourses + sumDesserts;
        return check;
    }

    public List viewReserved() {
        List<ReservedTable> reservedTableList = savedXMLLoader.reservedTables;
        return reservedTableList;
    }

}
