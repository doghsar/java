package tn.esprit.gestionzoo.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SocieteArrayList implements IGestion<Employee> {
    private ArrayList<Employee> employees;

    public SocieteArrayList() {
        this.employees = new ArrayList<>();
    }

    @Override
    public void ajouterEmploye(Employee employee) {
        employees.add(employee);
    }

    @Override
    public boolean rechercherEmploye(String nom) {
        for (Employee employee : employees) {
            if (employee.getLastName().equals(nom)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rechercherEmploye(Employee employee) {
        return employees.contains(employee);
    }

    @Override
    public void supprimerEmploye(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public void displayEmploye() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Override
    public void trierEmployeParId() {
        Collections.sort(employees, Comparator.comparingInt(Employee::getId));
    }

    @Override
    public void trierEmployeParNomDépartementEtGrade() {
        Collections.sort(employees, Comparator.comparing(Employee::getLastName)
                .thenComparing(Employee::getDepartmentName)
                .thenComparingInt(Employee::getGrade));
    }
}

