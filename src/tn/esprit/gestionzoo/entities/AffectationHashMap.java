package tn.esprit.gestionzoo.entities;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashSet;
import java.util.Set;
public class AffectationHashMap {
    private Map<Employee, Departement> affectations;

        public AffectationHashMap() {
            this.affectations = new HashMap<>();
        }

        public void affecterEmployeADepartement(Employee employee, Departement departement) {
            if (employee == null || departement == null) {
                throw new IllegalArgumentException("Employee and Department must not be null");
            }

            // Vérifier si l'employé est déjà affecté à un département
            if (affectations.containsKey(employee)) {
                System.out.println("Cet employé est déjà affecté à un département.");
            } else {
                // Ajouter l'affectation dans la map
                affectations.put(employee, departement);
                // Mettre à jour le nombre d'employés dans le département
                departement.setNumberOfEmployees(departement.getNumberOfEmployees() + 1);
            }
        }


    public void supprimerEmployeEtDepartement(Employee employee, Departement department) {
        if (employee == null || department == null) {
            throw new IllegalArgumentException("Employee and Department must not be null");
        }

        // Vérifier si l'employé est affecté au département spécifié
        if (affectations.containsKey(employee) && affectations.get(employee).equals(department)) {
            // Supprimer l'employé de la map
            affectations.remove(employee);
            // Mettre à jour le nombre d'employés dans le département
            department.setNumberOfEmployees(department.getNumberOfEmployees() - 1);
            System.out.println("L'employé " + employee.getFirstName() + " " + employee.getLastName() +
                    " a été retiré du département " + department.getDepartmentName() + ".");
        } else {
            System.out.println("Cet employé n'est pas affecté à ce département.");
        }
    }
      public void afficherEmployes() {
        System.out.println("Liste des Employés :");
        for (Employee employee : affectations.keySet()) {
            System.out.println(employee.getFirstName() + " " + employee.getLastName());
        }
    }
    public void afficherDepartements() {
        System.out.println("Liste des Départements :");
        // Utiliser un ensemble pour éviter l'affichage de départements en double
        Set<Departement> departments = new HashSet<>(affectations.values());
        for (Departement department : departments) {
            System.out.println(department.getDepartmentName());
        }
    }

        public void afficherEmployesEtDepartements() {
            System.out.println("Employés et Départements :");
            for (Map.Entry<Employee, Departement> entry : affectations.entrySet()) {
                Employee employee = entry.getKey();
                Departement departement = entry.getValue();
                System.out.println(employee.getFirstName() + " " + employee.getLastName() + " -> " + departement.getDepartmentName());
            }
        }

        public Departement getDepartementPourEmploye(Employee employee) {
            if (employee == null) {
                throw new IllegalArgumentException("Employee must not be null");
            }
            return affectations.get(employee);
        }

        public void ajouterEmployeDepartement(Employee employee, Departement newDepartement) {
            if (employee == null || newDepartement == null) {
                throw new IllegalArgumentException("Employee and Department must not be null");
            }

            // Vérifier si l'employé est déjà affecté à un département
            if (affectations.containsKey(employee)) {
                System.out.println("Cet employé est déjà affecté à un département.");
            } else {
                // Ajouter l'affectation dans la map
                affectations.put(employee, newDepartement);
                // Mettre à jour le nombre d'employés dans le nouveau département
                newDepartement.setNumberOfEmployees(newDepartement.getNumberOfEmployees() + 1);
            }
        }
         public boolean rechercherEmploye(Employee employee) {
           if (employee == null) {
            throw new IllegalArgumentException("Employee must not be null");
           }

        // Vérifier si l'employé existe dans la collection des affectations
        return affectations.containsKey(employee);
    }

    // Autres méthodes omises pour la concision...

    // Getter pour accéder à la collection des affectations
    /*public Map<Employee, Departement> getAffectations() {
        return affectations; }*/

    public boolean rechercherDepartement(Departement department) {
        if (department == null) {
            throw new IllegalArgumentException("Department must not be null");
        }

        // Vérifier si le département existe dans la collection des affectations
        return affectations.containsValue(department);
    }

    // Autres méthodes omises pour la concision...

    // Getter pour accéder à la collection des affectations
    public Map<Employee, Departement> getAffectations() {
        return affectations;
    }
    public TreeMap<Employee, Departement> trierMap() {
        // Créer un TreeMap à partir de la HashMap existante
        TreeMap<Employee, Departement> sortedMap = new TreeMap<>(new EmployeeComparatorById());

        // Ajouter toutes les entrées de la HashMap à la TreeMap
        sortedMap.putAll(affectations);

        return sortedMap;
    }

    // Classe interne pour définir le comparateur pour trier par identifiant d'employé
    private class EmployeeComparatorById implements java.util.Comparator<Employee> {
        @Override
        public int compare(Employee emp1, Employee emp2) {
            return Integer.compare(emp1.getId(), emp2.getId());
        }
    }
    }

