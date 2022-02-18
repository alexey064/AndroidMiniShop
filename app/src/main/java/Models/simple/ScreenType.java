package Models.simple;

import java.util.ArrayList;
import java.util.List;

import Models.linked.Notebook;
import Models.linked.Smartphone;

public class ScreenType {
    public ScreenType()
    {
        Notebooks = new ArrayList<Notebook>();
        Smartphones = new ArrayList<Smartphone>();
    }

    public int Id;
    public String Name;

    public List<Notebook> Notebooks;

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

    public List<Smartphone> Smartphones;
}
