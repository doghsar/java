package tn.esprit.gestionzoo.entities;

public class Aquatic extends Animal implements Carnivore<Food> {
    protected String habitat;

    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal);
        this.habitat = habitat;}

    public String getHabitat() {
        return habitat; }

    public void setHabitat(String habitat) {
        this.habitat = habitat;}
    public void swim () {
        System.out.println("this aquatic is animal is swimming ");
    }
    @Override
    public String toString() {
        return super.toString() +
                ", habitat='" + habitat + '\'';
    }
    public void eatMeat(Food meat) {
        if (meat == Food.MEAT || meat == Food.BOTH) {
            System.out.println("Aquatic animal eats meat.");
        } else {
            System.out.println("Aquatic animal does not eat meat.");
        }
    }
}