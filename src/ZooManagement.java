/*import tn.esprit.gestionzoo.entitees.Animal;
import tn.esprit.gestionzoo.entitees.Zoo;*/

public class ZooManagement {
    public static void main(String[] args) {

        Animal genericAnimal = new Animal("Generic Family", "Generic Animal", 1, true);

        Aquatic genericAquatic = new Aquatic("Aquatic Family", "Aquatic Animal", 2, true, "Aquatic Habitat");

        Terrestrial genericTerrestrial = new Terrestrial("Terrestrial Family", "Terrestrial Animal", 3, true, 4);
        Dolphin dolphin = new Dolphin("Dolphin Family", "Flipper", 5, true, "Ocean", 15.0f);
        Penguin penguin = new Penguin("Penguin Family", "Chilly", 2, true, "Antarctica", 50.0f);

        displayAnimalInfo(genericAnimal);
        displayAquaticInfo(genericAquatic);
        displayTerrestrialInfo(genericTerrestrial);
        displayAquaticInfo(dolphin);
        displayAquaticInfo(penguin);

        Animal lion = new Animal("Felidae", "Simba", 5, true);

        Zoo myZoo = new Zoo("Wildlife Park", "Ariana");
        Zoo notMyZoo = new Zoo("WaterPark", "Siliana");

        Animal dog = new Animal("Canine", "Snoopy", 2, true);

        /*System.out.println(myZoo.addAnimal(lion));
        System.out.println(myZoo.addAnimal(dog));*/

        myZoo.displayAnimals();

        System.out.println(myZoo.searchAnimal(dog));
        Animal dog2 = new Animal("Canine", "lll", 2, true);
        System.out.println(myZoo.searchAnimal(dog2));

        myZoo.displayAnimals();

        System.out.println(myZoo);

       /* myZoo.addAnimal(lion);
        myZoo.addAnimal(dog);
        myZoo.addAnimal(dog2);*/
        myZoo.displayAnimals();
        System.out.println("a" + myZoo.removeAnimal(lion));
        myZoo.displayAnimals();
        System.out.println("a" + myZoo.removeAnimal(dog2));
        myZoo.displayAnimals();
        System.out.println("a" + myZoo.removeAnimal(dog));
        myZoo.displayAnimals();
    }

    private static void displayAnimalInfo(Animal animal) {
        System.out.println("Animal Info: " + animal);
    }

    private static void displayAquaticInfo(Aquatic aquatic) {
        System.out.println("Aquatic Info: " + aquatic);
    }

    private static void displayTerrestrialInfo(Terrestrial terrestrial) {
        System.out.println("Terrestrial Info: " + terrestrial);
    }

}
