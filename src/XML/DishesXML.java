package XML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "dishes")
@XmlAccessorType(XmlAccessType.FIELD)
public class DishesXML {

    @XmlElement(name = "dish")
    private List<DishXML> dishxml;

    public List<DishXML> getDish() {
        return dishxml;
    }

    public void setDish(List<DishXML> dish) {
        this.dishxml = dish;
    }
}
