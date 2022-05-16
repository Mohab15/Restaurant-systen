package restaurant;

public class Order {
    private String name;
    private int tableNumber;
    private double price;
    private String[] order;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String[] getOrder() {
        return order;
    }

    public void setOrder(String[] order) {
        this.order = order;
    }

}
