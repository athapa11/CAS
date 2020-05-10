package Main;


public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
      this.product = product;
      this.quantity = quantity;
    }
/*
    public String getTitle() {
        return product.getTitle();
    }
    public String getAuthor() {
        return product.getAuthor();
    }
    public float getPrice() {
        return product.getPrice();
    }
    public int getQuantity() {
        return this.quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public float getTotalCost() {
        return product.getPrice()*this.quantity;
    } */
}
