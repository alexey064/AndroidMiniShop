package Models.simple;

import java.util.List;

import Models.linked.Smartphone;
import Models.linked.WireHeadphone;
import Models.linked.WirelessHeadphone;

public class ChargingType {
    public int Id;
    public String Name;
    public List<WireHeadphone> WireHeadphone;
    public List<WirelessHeadphone> WirelessHeadphones;

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

    public List<Models.linked.WireHeadphone> getWireHeadphone() {
        return WireHeadphone;
    }

    public void setWireHeadphone(List<WireHeadphone> wireHeadphone) {
        WireHeadphone = wireHeadphone;
    }

    public List<WirelessHeadphone> getWirelessHeadphones() {
        return WirelessHeadphones;
    }

    public void setWirelessHeadphones(List<WirelessHeadphone> wirelessHeadphones) {
        WirelessHeadphones = wirelessHeadphones;
    }

    public List<Models.linked.Smartphone> getSmartphone() {
        return Smartphone;
    }

    public void setSmartphone(List<Smartphone> smartphone) {
        Smartphone = smartphone;
    }

    public List<Smartphone> Smartphone;
}