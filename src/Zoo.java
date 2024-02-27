//package tn.esprit.gestionzoo.entitees;

public class Zoo {

    public static final int NUMBER_OF_CAGES = 25;
    private Animal[] animals;
    private String name, city;
    private int nbrAnimals;

    public Zoo() {
        animals = new Animal[NUMBER_OF_CAGES];
    }

    public Zoo(String name, String city) {
        this.name = name;
        this.city = city;
        animals = new Animal[NUMBER_OF_CAGES];
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.nbrAnimals > z2.nbrAnimals)
            return z1;
        return z2;
    }

    public void displayZoo() {
        System.out.println("Name: " + name + ", City: " + city + ", N° Cages: " + NUMBER_OF_CAGES + ", N° animals: " + nbrAnimals);
    }

    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("Le zoo est plein, impossible d'ajouter plus d'animaux.");
            return false;
        }

        for (int i = 0; i < nbrAnimals; i++) {
            if (animals[i].equals(animal)) {
                System.out.println("L'animal " + animal.getName() + " existe déjà dans le zoo.");
                return false;
            }
        }

        animals[nbrAnimals] = animal;
        nbrAnimals++;
        return true;
    }
    public String getName() {
        return this.name;
    }
    public void setName (String name){
        if (name.isBlank())
            System.out.println("name must contain caractere");
        this.name =name;
    }
    public String getCity(){
        return this.city;
    }
    public void setCity (String city){
        this.city=city;
    }
    public void setNbrAnimals(int nbranimal){
        this.nbrAnimals=nbranimal;
    }
    public int getNbrAnimals(){
        return this.nbrAnimals;
    }
    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            System.out.println("L'animal " + animal.getName() + " n'existe pas dans le zoo.");
            return false;
        }

        for (int i = index; i < nbrAnimals - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[nbrAnimals - 1] = null;
        nbrAnimals--;
        return true;
    }

    public void displayAnimals() {
        System.out.println("Liste des animaux du zoo " + name + ":");
        for (int i = 0; i < nbrAnimals; i++) {
            System.out.println(animals[i]);
        }
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < nbrAnimals; i++) {
            if (animals[i].equals(animal)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isZooFull() {
        return nbrAnimals == NUMBER_OF_CAGES;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", City: " + city + ", N° Cages: " + NUMBER_OF_CAGES + ", N° animals: " + nbrAnimals;
    }
}