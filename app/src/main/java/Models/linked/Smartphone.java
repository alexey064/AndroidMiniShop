package Models.linked;

import Models.simple.ChargingType;
import Models.simple.OS;
import Models.simple.Processor;
import Models.simple.ScreenType;

public class Smartphone {
    public int Id ;
    public int ScreenTypeId ;
    public int OSId ;
    public int ProductId ;
    public int ChargingTypeId ;
    public int ProcessorId ;

    public int MemoryCount ;
    public byte RAMCount ;
    public int BatteryCapacity ;
    public String Camera ;
    public String PhoneSize ;
    public int Weight ;
    public boolean NFC ;
    public short SimCount ;

    public String Communication ;
    public double ScreenSize ;
    public String Optional ;
    public String ScreenResolution ;
    public Models.simple.OS OS ;

    public Models.simple.Processor Processor ;
    public Models.simple.ScreenType ScreenType ;
    public Models.simple.ChargingType ChargingType ;

    public Product product ;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getScreenTypeId() {
        return ScreenTypeId;
    }

    public void setScreenTypeId(int screenTypeId) {
        ScreenTypeId = screenTypeId;
    }

    public int getOSId() {
        return OSId;
    }

    public void setOSId(int OSId) {
        this.OSId = OSId;
    }

    public int getMemoryCount() {
        return MemoryCount;
    }

    public void setMemoryCount(int memoryCount) {
        MemoryCount = memoryCount;
    }

    public byte getRAMCount() {
        return RAMCount;
    }

    public void setRAMCount(byte RAMCount) {
        this.RAMCount = RAMCount;
    }

    public int getBatteryCapacity() {
        return BatteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        BatteryCapacity = batteryCapacity;
    }

    public String getCamera() {
        return Camera;
    }

    public void setCamera(String camera) {
        Camera = camera;
    }

    public String getPhoneSize() {
        return PhoneSize;
    }

    public void setPhoneSize(String phoneSize) {
        PhoneSize = phoneSize;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public boolean isNFC() {
        return NFC;
    }

    public void setNFC(boolean NFC) {
        this.NFC = NFC;
    }

    public short getSimCount() {
        return SimCount;
    }

    public void setSimCount(short simCount) {
        SimCount = simCount;
    }

    public int getChargingTypeId() {
        return ChargingTypeId;
    }

    public void setChargingTypeId(int chargingTypeId) {
        ChargingTypeId = chargingTypeId;
    }

    public String getCommunication() {
        return Communication;
    }

    public void setCommunication(String communication) {
        Communication = communication;
    }

    public double getScreenSize() {
        return ScreenSize;
    }

    public void setScreenSize(double screenSize) {
        ScreenSize = screenSize;
    }

    public int getProcessorId() {
        return ProcessorId;
    }

    public void setProcessorId(int processorId) {
        ProcessorId = processorId;
    }

    public String getOptional() {
        return Optional;
    }

    public void setOptional(String optional) {
        Optional = optional;
    }

    public String getScreenResolution() {
        return ScreenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        ScreenResolution = screenResolution;
    }

    public Models.simple.OS getOS() {
        return OS;
    }

    public void setOS(Models.simple.OS OS) {
        this.OS = OS;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Models.simple.Processor getProcessor() {
        return Processor;
    }

    public void setProcessor(Models.simple.Processor processor) {
        Processor = processor;
    }

    public Models.simple.ScreenType getScreenType() {
        return ScreenType;
    }

    public void setScreenType(Models.simple.ScreenType screenType) {
        ScreenType = screenType;
    }

    public Models.simple.ChargingType getChargingType() {
        return ChargingType;
    }

    public void setChargingType(Models.simple.ChargingType chargingType) {
        ChargingType = chargingType;
    }
}
