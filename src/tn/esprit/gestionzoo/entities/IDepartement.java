package tn.esprit.gestionzoo.entities;
import java.util.TreeSet;

public interface IDepartement<T extends Departement> {
    void ajouterDepartement(T t);
    boolean rechercherDepartement(String nom);
    boolean rechercherDepartement(T t);
    void supprimerDepartement(T t);
    void displayDepartement();
    TreeSet<T> trierDepartementById();
}

