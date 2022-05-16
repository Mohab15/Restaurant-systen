package reservedRestaurant;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "reservedTable")
@XmlAccessorType(XmlAccessType.FIELD)


public class ReservedTable {
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "number")
    private int number;
    @XmlElement(name = "price")
    private double price;
    @XmlElement(name = "order")
    private String[] order;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
