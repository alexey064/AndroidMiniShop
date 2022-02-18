package Models.linked;

import java.util.Date;
import java.util.List;

import Models.simple.Department;
import Models.simple.Type;

public class PurchaseHistory {
    public PurchaseHistory()
    {

    }
    public int Id ;
    public Date PurchaseDate ;
    public int ClientId ;
    public int SellerId ;
    public int StatusId ;
    public int DepartmentId ;
    public int TotalCost ;
    public Client Client ;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Date getPurchaseDate() {
        return PurchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        PurchaseDate = purchaseDate;
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public int getSellerId() {
        return SellerId;
    }

    public void setSellerId(int sellerId) {
        SellerId = sellerId;
    }

    public int getStatusId() {
        return StatusId;
    }

    public void setStatusId(int statusId) {
        StatusId = statusId;
    }

    public int getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(int departmentId) {
        DepartmentId = departmentId;
    }

    public int getTotalCost() {
        return TotalCost;
    }

    public void setTotalCost(int totalCost) {
        TotalCost = totalCost;
    }

    public Models.linked.Client getClient() {
        return Client;
    }

    public void setClient(Models.linked.Client client) {
        Client = client;
    }

    public Models.linked.Client getSeller() {
        return Seller;
    }

    public void setSeller(Models.linked.Client seller) {
        Seller = seller;
    }

    public Type getStatus() {
        return Status;
    }

    public void setStatus(Type status) {
        Status = status;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Models.linked.ProdMovement> getProdMovement() {
        return ProdMovement;
    }

    public void setProdMovement(List<Models.linked.ProdMovement> prodMovement) {
        ProdMovement = prodMovement;
    }

    public Client Seller ;
    public Type Status ;
    public Department department ;
    //public virtual int ProdMovementId ;
    public List<ProdMovement> ProdMovement ;
}
