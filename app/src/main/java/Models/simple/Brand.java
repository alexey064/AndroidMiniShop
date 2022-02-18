package Models.simple;

import java.util.List;

import Models.linked.Product;

public class Brand {
    public int Id;
    public String Name;
    public List<Product> Products;

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

    public List<Product> getProducts() {
        return Products;
    }

    public void setProducts(List<Product> products) {
        Products = products;
    }
}
