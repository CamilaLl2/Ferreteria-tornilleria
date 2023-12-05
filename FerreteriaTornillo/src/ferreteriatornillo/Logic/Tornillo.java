package ferreteriatornillo.Logic;

public abstract class Tornillo extends Product{
    public Tornillo(String id, String title, String description, int stock, double price, String imgName) {
        super(id, title, description, stock, price, imgName);        
    }    
}
