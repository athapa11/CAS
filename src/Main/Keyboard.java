package Main;

public class Keyboard extends Product
{
	private String keyboardType;
	private String keyboardLayout;
	
	public Keyboard(int barcode, String productType, String keyboardType, String brand, String colour, String connectivity, int stockQuantity, double originalCost, double retailPrice, String keyboardLayout)
	{
		super(barcode, productType, brand, colour, connectivity, stockQuantity, originalCost, retailPrice);
		this.keyboardType = keyboardType;
		this.keyboardLayout = keyboardLayout;
	}
	
	// Getter Methods
	public String getKeyboardType(){return this.keyboardType;}
	public String getKeyboardLayout(){return this.keyboardLayout;}

	public String toString() //Override
	{
		return ("Barcode: " + getBarcode() + ", " + "Product: " + getProductType() + ", " + "Type: " + this.keyboardType + ", " + 
	"Brand: " + getBrand() + ", " + "Colour: " + getColour() + ", " + "Connectivity: " + getConnectivity() + ", " + 
				"Quantity: " + getStockQuantity() + ", " + "Price: " + getRetailPrice() + ", " + "Layout: " + this.keyboardLayout);
	}
}
