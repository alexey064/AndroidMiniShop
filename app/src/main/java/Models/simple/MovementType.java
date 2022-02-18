package Models.simple;

import java.util.ArrayList;
import java.util.List;

import Models.linked.ProdMovement;

public class MovementType {
    public MovementType()
    {
        ProdMovements = new ArrayList<ProdMovement>();
    }

    public int Id;
    public String Name;

    public List<ProdMovement> ProdMovements;

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

    public List<ProdMovement> getProdMovements() {
        return ProdMovements;
    }

    public void setProdMovements(List<ProdMovement> prodMovements) {
        ProdMovements = prodMovements;
    }
}
