package functions;

import javax.xml.bind.annotation.XmlElement;

public class Last {

    private String name;

    private int numberoftable;

    private double totalpayment;

    private int grilled_chicken;

    private int greek_salade;

    private int fried_potatos;

    private int apple_pie;

    private int molten_cake;

    private int mushroom_soup;

    private int beef_steak;

    public Last(String name, int numberoftable, double totalpayment, int grilled_chicken, int greek_salade, int fried_potatos, int apple_pie, int molten_cake, int mushroom_soup, int beef_steak) {
        this.name = name;
        this.numberoftable = numberoftable;
        this.totalpayment = totalpayment;
        this.grilled_chicken = grilled_chicken;
        this.greek_salade = greek_salade;
        this.fried_potatos = fried_potatos;
        this.apple_pie = apple_pie;
        this.molten_cake = molten_cake;
        this.mushroom_soup = mushroom_soup;
        this.beef_steak = beef_steak;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberoftable() {
        return numberoftable;
    }

    public void setNumberoftable(int numberoftable) {
        this.numberoftable = numberoftable;
    }

    public double getTotalpayment() {
        return totalpayment;
    }

    public void setTotalpayment(double totalpayment) {
        this.totalpayment = totalpayment;
    }

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
