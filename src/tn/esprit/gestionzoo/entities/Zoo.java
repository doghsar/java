package tn.esprit.gestionzoo.entities;//package tn.esprit.gestionzoo.entitees;

public class Zoo {
    public static final int NUMBER_OF_CAGES = 3;
    private Animal[] animals;
    private Aquatic[] aquaticAnimals;
    private String name, city;
    private int nbrAnimals;
    private int nbrAquaticAnimals;


    public Zoo() {
        animals = new Animal[NUMBER_OF_CAGES];
        aquaticAnimals = new Aquatic[10];
        nbrAnimals = 0;
        nbrAquaticAnimals = 0;
    }

    public Zoo(String name, String city) {
        this.name = name;
        this.city = city;
        animals = new Animal[NUMBER_OF_CAGES];
        aquaticAnimals = new Aquatic[10];
        nbrAnimals = 0;
        nbrAquaticAnimals = 0;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.nbrAnimals > z2.nbrAnimals)
            return z1;
        return z2;
    }

    public void displayZoo() {
        System.out.println("Name: " + name + ", City: " + city + ", N° Cages: " + NUMBER_OF_CAGES + ", N° animals: " + nbrAnimals);
    }


    public void addAnimal(Animal animal) throws ZooFullException {
        if (nbrAnimals < animals.length) {
            try {
                animal.setAge(animal.getAge());  // Vérifie l'âge avant d'ajouter
                animals[nbrAnimals] = animal;
                nbrAnimals++;
                System.out.println("Animal ajouté Nombre d'animaux : " + nbrAnimals);
            } catch (InvalidAgeException e) {
                System.err.println("Erreur : " + e.getMessage());
            }
        } else {
            throw new ZooFullException("Le zoo est plein, impossible d'ajouter plus d'animaux.");
        }
    }
    public void addAquaticAnimal(Aquatic aquaticAnimal) throws ZooFullException {
        if (nbrAquaticAnimals < aquaticAnimals.length) {
            aquaticAnimals[nbrAquaticAnimals] = aquaticAnimal;
            nbrAquaticAnimals++;
            System.out.println("Aquatic animal added. Number of aquatic animals: " + nbrAquaticAnimals);
        } else {
            throw new ZooFullException("Le tableau des animaux aquatiques est plein. Impossible d'ajouter plus d'animaux aquatiques.");
        }
    }
    private boolean isAquaticAnimalsFull() {
        return nbrAquaticAnimals == aquaticAnimals.length;
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
    public float maxPenguinSwimmingDepth() {
        float maxDepth = Float.MIN_VALUE;

        for (Aquatic aquaticAnimal : aquaticAnimals) {
            if (aquaticAnimal instanceof Penguin) {
                Penguin penguin = (Penguin) aquaticAnimal;
                maxDepth = Math.max(maxDepth, penguin.getSwimmingDepth());
            }
        }

        if (maxDepth == Float.MIN_VALUE) {
            System.out.println("No penguins found in the zoo.");
            return 0.0f; // Or any default value indicating no penguins
        }

        return maxDepth;
    }
    public void displayNumberOfAquaticsByType() {
        int numberOfDolphins = 0;
        int numberOfPenguins = 0;

        for (Aquatic aquaticAnimal : aquaticAnimals) {
            if (aquaticAnimal instanceof Dolphin) {
                numberOfDolphins++;
            } else if (aquaticAnimal instanceof Penguin) {
                numberOfPenguins++;
            }
        }

        System.out.println("Number of Dolphins: " + numberOfDolphins);
        System.out.println("Number of Penguins: " + numberOfPenguins);
    }


    @Override
    public String toString() {
        return "Name: " + name + ", City: " + city + ", N° Cages: " + NUMBER_OF_CAGES + ", N° animals: " + nbrAnimals;
    }
}