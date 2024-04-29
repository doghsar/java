package tn.esprit.gestionzoo.entities;
import java.util.Objects;
public class Departement {
    private int id;
    private String departmentName;
    private int numberOfEmployees;

    public Departement() {
    }

    public Departement(int id, String departmentName, int numberOfEmployees) {
        this.id = id;
        this.departmentName = departmentName;
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Departement that = (Departement) obj;
        return id == that.id &&
                Objects.equals(departmentName, that.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentName);
    }

    @Override
    public String toString() {
        return "Departement{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", numberOfEmployees=" + numberOfEmployees +
                '}';
    }

}
