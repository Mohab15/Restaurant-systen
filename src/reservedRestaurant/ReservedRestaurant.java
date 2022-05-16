package reservedRestaurant;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "reservedRestaurant")
@XmlAccessorType(XmlAccessType.FIELD)

public class ReservedRestaurant {
    @XmlElement(name = "reservedTables")
    private ReservedTables reservedTables = null;

    public ReservedTables getReservedTables() {
        return reservedTables;
    }

    public void setReservedTables(ReservedTables reservedTables) {
        this.reservedTables = reservedTables;
    }
}



