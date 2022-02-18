package Models.linked;

import java.util.Date;
import java.util.List;

import Models.simple.Brand;
import Models.simple.Color;
import Models.simple.Department;
import Models.simple.Type;

public class Product {
    public int ProductId ;
    public int TypeId ;
    public int DepartmentId ;
    public int BrandId ;
    public int ColorId ;
    public String Name ;
    public String Description ;
    public int Price ;
    public String Photo ;
    public double Discount ;
    public Date DiscountDate ;
    public Date AddDate;
    public Models.simple.Department Department ;
    public Smartphone Smartphone ;
    public WirelessHeadphone WirelessHeadphones ;
    public WireHeadphone WireHeadphones ;
    public Accessory Accessory ;
    public Notebook Notebook ;

    public Models.simple.Type Type ;
    public Models.simple.Brand Brand ;
    public Models.simple.Color Color ;
    public int Count ;

    public List<ProdMovement> ProdMovements ;

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getTypeId() {
        return TypeId;
    }

    public void setTypeId(int typeId) {
        TypeId = typeId;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(int departmentId) {
        DepartmentId = departmentId;
    }

    public int getBrandId() {
        return BrandId;
    }

    public void setBrandId(int brandId) {
        BrandId = brandId;
    }

    public int getColorId() {
        return ColorId;
    }

    public void setColorId(int colorId) {
        ColorId = colorId;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double discount) {
        Discount = discount;
    }

    public Date getDiscountDate() {
        return DiscountDate;
    }

    public void setDiscountDate(Date discountDate) {
        DiscountDate = discountDate;
    }

    public Date getAddDate() {
        return AddDate;
    }

    public void setAddDate(Date addDate) {
        AddDate = addDate;
    }

    public Models.simple.Type getType() {
        return Type;
    }

    public void setType(Models.simple.Type type) {
        Type = type;
    }

    public Models.simple.Brand getBrand() {
        return Brand;
    }

    public void setBrand(Models.simple.Brand brand) {
        Brand = brand;
    }

    public Models.simple.Department getDepartment() {
        return Department;
    }

    public void setDepartment(Models.simple.Department department) {
        Department = department;
    }

    public Smartphone getSmartphone() {
        return Smartphone;
    }

    public void setSmartphone(Smartphone smartphone) {
        Smartphone = smartphone;
    }

    public Models.simple.Color getColor() {
        return Color;
    }

    public void setColor(Models.simple.Color color) {
        Color = color;
    }

    public WirelessHeadphone getWirelessHeadphones() {
        return WirelessHeadphones;
    }

    public void setWirelessHeadphones(WirelessHeadphone wirelessHeadphones) {
        WirelessHeadphones = wirelessHeadphones;
    }

    public WireHeadphone getWireHeadphones() {
        return WireHeadphones;
    }

    public void setWireHeadphones(WireHeadphone wireHeadphones) {
        WireHeadphones = wireHeadphones;
    }

    public Models.linked.Accessory getAccessory() {
        return Accessory;
    }

    public void setAccessory(Models.linked.Accessory accessory) {
        Accessory = accessory;
    }

    public Models.linked.Notebook getNotebook() {
        return Notebook;
    }

    public void setNotebook(Models.linked.Notebook notebook) {
        Notebook = notebook;
    }

    public List<ProdMovement> getProdMovements() {
        return ProdMovements;
    }

    public void setProdMovements(List<ProdMovement> prodMovements) {
        ProdMovements = prodMovements;
    }

}
