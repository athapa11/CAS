package Main;


public class BasketItem {
	
    private Product product;
    private int quantity;

    public BasketItem(Product product, int quantity) {
      this.product = product;
      this.quantity = quantity;
    }

    public Product getProduct() {
        return this.product;
    }
    
    public int getQuantity() {
        return this.quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    // Total cost of a stock of one item
    public double getTotalCostOfItem() {
        return product.getRetailPrice()*this.quantity;
    } 
}
