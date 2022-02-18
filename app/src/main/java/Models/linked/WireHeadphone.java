package Models.linked;

import Models.simple.ChargingType;

public class WireHeadphone {
    public int Id ;
    public int ConnectionTypeId ;
    public int ProductId ;
    public Product Product ;
    public double WireLenght ;
    public ChargingType ConnectionType ;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getConnectionTypeId() {
        return ConnectionTypeId;
    }

    public void setConnectionTypeId(int connectionTypeId) {
        ConnectionTypeId = connectionTypeId;
    }

    public double getWireLenght() {
        return WireLenght;
    }

    public void setWireLenght(double wireLenght) {
        WireLenght = wireLenght;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public Models.linked.Product getProduct() {
        return Product;
    }

    public void setProduct(Models.linked.Product product) {
        Product = product;
    }

    public ChargingType getConnectionType() {
        return ConnectionType;
    }

    public void setConnectionType(ChargingType connectionType) {
        ConnectionType = connectionType;
    }


}
