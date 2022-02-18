package Models.simple;

import java.util.ArrayList;
import java.util.List;

import Models.linked.Notebook;
import Models.linked.Smartphone;

public class Processor {
    public Processor()
    {
        Notebooks = new ArrayList<Notebook>();
        Smartphones = new ArrayList<Smartphone>();
    }

    public int Id;

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

    public String getAddInfo() {
        return AddInfo;
    }

    public void setAddInfo(String addInfo) {
        AddInfo = addInfo;
    }

    public List<Notebook> getNotebooks() {
        return Notebooks;
    }

    public void setNotebooks(List<Notebook> notebooks) {
        Notebooks = notebooks;
    }

    public List<Smartphone> getSmartphones() {
        return Smartphones;
    }

    public void setSmartphones(List<Smartphone> smartphones) {
        Smartphones = smartphones;
    }

    public String Name;
    public String AddInfo;

    public List<Notebook> Notebooks;
    public List<Smartphone> Smartphones;
}
