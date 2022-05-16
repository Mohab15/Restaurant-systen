package reservedRestaurant;

import XML.User;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "reservedTables")
@XmlAccessorType(XmlAccessType.FIELD)

public class ReservedTables {
    private List<ReservedTable> reservedTables;

    public List<ReservedTable> getReservedTables() {
        return reservedTables;
    }

    public void setReservedTables(List<ReservedTable> reservedTables) {
        this.reservedTables = reservedTables;
    }


}