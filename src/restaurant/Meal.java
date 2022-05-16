package restaurant;

import XML.Dish;
import XML.XMLReader;

import java.util.List;

public class Meal {
    private String name;
    private double price;
    private List<Dish> dishes_list = XMLReader.dishes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Dish getMeal(String name) {
        for (int i = 0; i < dishes_list.size(); i++) {
            if (dishes_list.get(i).getName().equals(name))
                return dishes_list.get(i);
        }
        return null;
    }
}

