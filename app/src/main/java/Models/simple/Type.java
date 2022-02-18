package Models.simple;

import java.util.ArrayList;
import java.util.List;

import Models.linked.Client;
import Models.linked.ProdMovement;
import Models.linked.Product;
import Models.linked.PurchaseHistory;

public class Type {
    public Type()
    {
        Clients = new ArrayList<Client>();
        ProdMovements = new ArrayList<ProdMovement>();
        Products = new ArrayList<Product>();
        PurchaseHistories = new ArrayList<PurchaseHistory>();
    }

    public int Id;
    public String Name;

    public List<ProdMovement> getProdMovements() {
        return ProdMovements;
    }

    public void setProdMovements(List<ProdMovement> prodMovements) {
        ProdMovements = prodMovements;
    }

    public List<Product> getProducts() {
        return Products;
    }

    public void setProducts(List<Product> products) {
        Products = products;
    }

    public List<PurchaseHistory> getPurchaseHistories() {
        return PurchaseHistories;
    }

    public void setPurchaseHistories(List<PurchaseHistory> purchaseHistories) {
        PurchaseHistories = purchaseHistories;
    }

    public String Category;

    public List<Client> Clients;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public List<Client> getClients() {
        return Clients;
    }

    public void setClients(List<Client> clients) {
        Clients = clients;
    }

    public List<ProdMovement> ProdMovements;
    public List<Product> Products;
    public List<PurchaseHistory> PurchaseHistories;
}
