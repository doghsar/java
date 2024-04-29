package tn.esprit.gestionzoo.entities;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

import java.util.HashSet;
import java.util.TreeSet;

public class DepartementHashSet<T extends Departement> implements IDepartement<T> {
    private HashSet<T> departements;

    public DepartementHashSet() {
        this.departements = new HashSet<>();
    }

    @Override
    public void ajouterDepartement(T departement) {
        departements.add(departement);
    }

    @Override
    public boolean rechercherDepartement(String nom) {
        for (T departement : departements) {
            if (departement.getDepartmentName().equals(nom)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rechercherDepartement(T departement) {
        return departements.contains(departement);
    }

    @Override
    public void supprimerDepartement(T departement) {
        departements.remove(departement);
    }

    @Override
    public void displayDepartement() {
        for (T departement : departements) {
            System.out.println(departement);
        }
    }

    @Override
    public TreeSet<T> trierDepartementById() {
        TreeSet<T> sortedDepartements = new TreeSet<>((d1, d2) -> Integer.compare(d1.getId(), d2.getId()));
        sortedDepartements.addAll(departements);
        return sortedDepartements;
    }
}
