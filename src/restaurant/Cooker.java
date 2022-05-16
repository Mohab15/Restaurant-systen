package restaurant;

import XML.Dish;
import XML.XMLReader;

import java.util.List;

public class Cooker extends ValidUser {

    public List<Dish> viewDishes() {
        List<Dish> dishes_list = XMLReader.dishes;
        return dishes_list;
    }
}
