package Models.simple;

import java.util.ArrayList;
import java.util.List;

import Models.linked.Client;
import Models.linked.Product;
import Models.linked.Provider;

public class Department {
    public Department()
    {
        Clients = new ArrayList<Client>();
        Products = new ArrayList<Product>();
        Providers = new ArrayList<Provider>();
    }

    public int DepartmentId;
    public String Adress;

    public List<Client> Clients;
    public List<Product> Products;
    public List<Provider> Providers;

    public int getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(int departmentId) {
        DepartmentId = departmentId;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public List<Client> getClients() {
        return Clients;
    }

    public void setClients(List<Client> clients) {
        Clients = clients;
    }

    public List<Product> getProducts() {
        return Products;
    }

    public void setProducts(List<Product> products) {
        Products = products;
    }

    public List<Provider> getProviders() {
        return Providers;
    }

    public void setProviders(List<Provider> providers) {
        Providers = providers;
    }
}
