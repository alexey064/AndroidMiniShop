package Models.linked;

import Models.simple.OS;
import Models.simple.Processor;
import Models.simple.ScreenType;
import Models.simple.Videocard;

public class Notebook {
    public int Id;
    public int ProcessorId;
    public int OSId;
    public int ScreenTypeId;
    public int ProductId;
    public int VideocardID;

    public byte RAMCount;
    public double Weight;
    public int HDDSize;
    public int SSDSize;
    public double ScreenSize;
    public String ScreenResolution;
    public String Camera;
    public String WirelessCommunication;
    public short BatteryCapacity;
    public String Outputs;
    public String Optional;
    public Models.simple.OS OS;
    public Videocard Videocard;
    public Processor Processor;
    public ScreenType ScreenType;

    public Product product;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getProcessorId() {
        return ProcessorId;
    }

    public void setProcessorId(int processorId) {
        ProcessorId = processorId;
    }

    public int getOSId() {
        return OSId;
    }

    public void setOSId(int OSId) {
        this.OSId = OSId;
    }

    public byte getRAMCount() {
        return RAMCount;
    }

    public void setRAMCount(byte RAMCount) {
        this.RAMCount = RAMCount;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double weight) {
        Weight = weight;
    }

    public int getVideocardID() {
        return VideocardID;
    }

    public void setVideocardID(int videocardID) {
        VideocardID = videocardID;
    }

    public int getHDDSize() {
        return HDDSize;
    }

    public void setHDDSize(int HDDSize) {
        this.HDDSize = HDDSize;
    }

    public int getSSDSize() {
        return SSDSize;
    }

    public void setSSDSize(int SSDSize) {
        this.SSDSize = SSDSize;
    }

    public double getScreenSize() {
        return ScreenSize;
    }

    public void setScreenSize(double screenSize) {
        ScreenSize = screenSize;
    }

    public String getScreenResolution() {
        return ScreenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        ScreenResolution = screenResolution;
    }

    public String getCamera() {
        return Camera;
    }

    public void setCamera(String camera) {
        Camera = camera;
    }

    public String getWirelessCommunication() {
        return WirelessCommunication;
    }

    public void setWirelessCommunication(String wirelessCommunication) {
        WirelessCommunication = wirelessCommunication;
    }

    public int getScreenTypeId() {
        return ScreenTypeId;
    }

    public void setScreenTypeId(int screenTypeId) {
        ScreenTypeId = screenTypeId;
    }

    public short getBatteryCapacity() {
        return BatteryCapacity;
    }

    public void setBatteryCapacity(short batteryCapacity) {
        BatteryCapacity = batteryCapacity;
    }

    public String getOutputs() {
        return Outputs;
    }

    public void setOutputs(String outputs) {
        Outputs = outputs;
    }

    public String getOptional() {
        return Optional;
    }

    public void setOptional(String optional) {
        Optional = optional;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public Models.simple.OS getOS() {
        return OS;
    }

    public void setOS(Models.simple.OS OS) {
        this.OS = OS;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Models.simple.Videocard getVideocard() {
        return Videocard;
    }

    public void setVideocard(Models.simple.Videocard videocard) {
        Videocard = videocard;
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


}
