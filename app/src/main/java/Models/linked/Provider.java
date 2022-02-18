package Models.linked;

import java.util.Date;
import java.util.List;

import Models.simple.Department;

public class Provider {
    public int Id ;
    public java.util.Date Date ;
    public int DepartmentId ;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public int getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(int departmentId) {
        DepartmentId = departmentId;
    }

    public Models.simple.Department getDepartment() {
        return Department;
    }

    public void setDepartment(Models.simple.Department department) {
        Department = department;
    }

    public List<Models.linked.ProdMovement> getProdMovement() {
        return ProdMovement;
    }

    public void setProdMovement(List<Models.linked.ProdMovement> prodMovement) {
        ProdMovement = prodMovement;
    }

    public Models.simple.Department Department ;
    public List<ProdMovement> ProdMovement ;
}
