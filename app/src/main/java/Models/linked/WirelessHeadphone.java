package Models.linked;

import Models.simple.ChargingType;

public class WirelessHeadphone {
    public int Id ;

    public double BluetoothVersion ;
    public int Radius ;
    public short Battery ;
    public short CaseBattery ;
    public int ChargingTypeId ;
    public int ProductId ;
    public Product Product ;
    public Models.simple.ChargingType ChargingType ;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public double getBluetoothVersion() {
        return BluetoothVersion;
    }

    public void setBluetoothVersion(double bluetoothVersion) {
        BluetoothVersion = bluetoothVersion;
    }

    public int getRadius() {
        return Radius;
    }

    public void setRadius(int radius) {
        Radius = radius;
    }

    public short getBattery() {
        return Battery;
    }

    public void setBattery(short battery) {
        Battery = battery;
    }

    public short getCaseBattery() {
        return CaseBattery;
    }

    public void setCaseBattery(short caseBattery) {
        CaseBattery = caseBattery;
    }

    public int getChargingTypeId() {
        return ChargingTypeId;
    }

    public void setChargingTypeId(int chargingTypeId) {
        ChargingTypeId = chargingTypeId;
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

    public Models.simple.ChargingType getChargingType() {
        return ChargingType;
    }

    public void setChargingType(Models.simple.ChargingType chargingType) {
        ChargingType = chargingType;
    }
}
