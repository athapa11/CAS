package Main;


public abstract class Product {
	private int barcode;
	private String productType;
	private String brand;
	private String colour;
	private String connectivity;
	private int stockQuantity;
	private double originalCost;
	private double retailPrice;
	
	public Product(int barcode, String productType, String brand, String colour, String connectivity, int stockQuantity, 
			double originalCost, double retailPrice)
	{
		this.barcode = barcode;
		this.productType = productType;
		this.brand = brand;
		this.colour = colour;
		this.connectivity = connectivity;
		this.stockQuantity = stockQuantity;
		this.originalCost = originalCost;
		this.retailPrice = retailPrice;
	}
	
	public abstract String toString();
	
	// Getter Methods
	public int getBarcode() {return this.barcode;}
	public String getProductType() {return this.productType;}
	public String getBrand() {return this.brand;}
	public String getColour() {return this.colour;}
	public String getConnectivity() {return this.connectivity;}
	public int getStockQuantity() {return this.stockQuantity;}
	public double getOriginalCost() {return this.originalCost;}
	public double getRetailPrice() {return this.retailPrice;}
	
}
