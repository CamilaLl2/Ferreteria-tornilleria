
package ferreteriatornillo.Logic;

public class ShopingCart {
    private Product product;
    private int amount;

    public ShopingCart(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }        
}
