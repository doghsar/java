package tn.esprit.gestionzoo.main;
import tn.esprit.gestionzoo.entities.Etudiant;
import tn.esprit.gestionzoo.entities.StudentManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ZooManagement {
    public static void main(String[] args) {

       /* Animal genericAnimal = new Animal("Generic Family", "Generic tn.esprit.gestionzoo.entities.Animal", 1, true);

        Aquatic genericAquatic = new Aquatic("tn.esprit.gestionzoo.entities.Aquatic Family", "tn.esprit.gestionzoo.entities.Aquatic tn.esprit.gestionzoo.entities.Animal", 2, true, "tn.esprit.gestionzoo.entities.Aquatic Habitat");

        Terrestrial genericTerrestrial = new Terrestrial("tn.esprit.gestionzoo.entities.Terrestrial Family", "tn.esprit.gestionzoo.entities.Terrestrial tn.esprit.gestionzoo.entities.Animal", 3, true, 4);
        Dolphin dolphin = new Dolphin("tn.esprit.gestionzoo.entities.Dolphin Family", "Flipper", 5, true, "Ocean", 15.0f);
        Penguin penguin = new Penguin("tn.esprit.gestionzoo.entities.Penguin Family", "Chilly", 2, true, "Antarctica", 50.0f);

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
        System.out.println(myZoo.addAnimal(dog));

        myZoo.displayAnimals();

        System.out.println(myZoo.searchAnimal(dog));
        Animal dog2 = new Animal("Canine", "lll", 2, true);
        System.out.println(myZoo.searchAnimal(dog2));

        myZoo.displayAnimals();

        System.out.println(myZoo);

       myZoo.addAnimal(lion);
        myZoo.addAnimal(dog);
        myZoo.addAnimal(dog2);
        myZoo.displayAnimals();
        System.out.println("a" + myZoo.removeAnimal(lion));
        myZoo.displayAnimals();
        System.out.println("a" + myZoo.removeAnimal(dog2));
        myZoo.displayAnimals();
        System.out.println("a" + myZoo.removeAnimal(dog));
        myZoo.displayAnimals();
    }

    private static void displayAnimalInfo(Animal animal) {
        System.out.println("tn.esprit.gestionzoo.entities.Animal Info: " + animal);
    }

    private static void displayAquaticInfo(Aquatic aquatic) {
        System.out.println("tn.esprit.gestionzoo.entities.Aquatic Info: " + aquatic);
    }

    private static void displayTerrestrialInfo(Terrestrial terrestrial) {
        System.out.println("tn.esprit.gestionzoo.entities.Terrestrial Info: " + terrestrial);
    }*/
        List<Etudiant> students = new ArrayList<>();
        students.add(new Etudiant(1, "Ali", 20));
        students.add(new Etudiant(2, "sarra", 23));
        students.add(new Etudiant(3, "brahim", 21));

        StudentManagement studentManagement = new StudentManagement();

        System.out.println("Liste des étudiants :");
        studentManagement.displayStudents(students, System.out::println);

        System.out.println("\nÉtudiants avec un âge supérieur à 20 :");
        Predicate<Etudiant> agePredicate = etudiant -> etudiant.getAge() > 20;
        studentManagement.displayStudentsByFilter(students, agePredicate, System.out::println);
    }
}
