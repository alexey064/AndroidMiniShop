package Models.simple;

import java.util.List;

import Models.linked.Notebook;

public class Videocard {
    public int Id;
    public String Name;

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

    public List<Notebook> Notebooks;
}
