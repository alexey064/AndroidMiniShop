package Models.ViewModel;

import java.util.ArrayList;
import java.util.List;

import Models.linked.Product;

public class MainPageData {
    private ArrayList<Product> NewlyAdded;
    private ArrayList<Product> MostBuyed;
    private ArrayList<Product> MaxDiscounted;
    public MainPageData()
    {
    }

    public ArrayList<Product> getNewlyAdded() {
        return NewlyAdded;
    }

    public void setNewlyAdded(ArrayList<Product> newlyAdded) {
        NewlyAdded = newlyAdded;
    }

    public ArrayList<Product> getMostBuyed() {
        return MostBuyed;
    }

    public void setMostBuyed(ArrayList<Product> mostBuyed) {
        MostBuyed = mostBuyed;
    }

    public ArrayList<Product> getMaxDiscounted() {
        return MaxDiscounted;
    }

    public void setMaxDiscounted(ArrayList<Product> maxDiscounted) {
        MaxDiscounted = maxDiscounted;
    }
}
