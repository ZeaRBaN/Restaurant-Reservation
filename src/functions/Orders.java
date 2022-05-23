package functions;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "orders")
@XmlAccessorType(XmlAccessType.FIELD)
public class Orders {

    @XmlElement(name = "grilled_chicken")
    private int grilled_chicken;

    @XmlElement(name = "greek_salade")
    private int greek_salade;

    @XmlElement(name = "fried_potatos")
    private int fried_potatos;

    @XmlElement(name = "apple_pie")
    private int apple_pie;

    @XmlElement(name = "molten_cake")
    private int molten_cake;

    @XmlElement(name = "mushroom_soup")
    private int mushroom_soup;

    @XmlElement(name = "beef_steak")
    private int beef_steak;

    public int getGrilled_chicken() {
        return grilled_chicken;
    }

    public void setGrilled_chicken(int grilled_chicken) {
        this.grilled_chicken = grilled_chicken;
    }

    public int getGreek_salade() {
        return greek_salade;
    }

    public void setGreek_salade(int greek_salade) {
        this.greek_salade = greek_salade;
    }

    public int getFried_potatos() {
        return fried_potatos;
    }

    public void setFried_potatos(int fried_potatos) {
        this.fried_potatos = fried_potatos;
    }

    public int getApple_pie() {
        return apple_pie;
    }

    public void setApple_pie(int apple_pie) {
        this.apple_pie = apple_pie;
    }

    public int getMolten_cake() {
        return molten_cake;
    }

    public void setMolten_cake(int molten_cake) {
        this.molten_cake = molten_cake;
    }

    public int getMushroom_soup() {
        return mushroom_soup;
    }

    public void setMushroom_soup(int mushroom_soup) {
        this.mushroom_soup = mushroom_soup;
    }

    public int getBeef_steak() {
        return beef_steak;
    }

    public void setBeef_steak(int beef_steak) {
        this.beef_steak = beef_steak;
    }
}
