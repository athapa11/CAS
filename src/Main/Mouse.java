package Main;

public class Mouse extends Product
{
	private String mouseType;
	private int buttonsTotal;
	
	public Mouse(int barcode,  String productType, String mouseType, String brand, String colour, String connectivity, int stockQuantity, double originalCost, double retailPrice, int buttonsTotal)
	{
		super(barcode, productType, brand, colour, connectivity, stockQuantity, originalCost, retailPrice);
		this.mouseType = mouseType;
		this.buttonsTotal = buttonsTotal;
	}
	
	// Getter Methods
	public String getMouseType() {return this.mouseType;}
	public int getButtonsTotal(){return this.buttonsTotal;}
	
	public String toString() //Override
	{
		return ("Barcode: " + getBarcode() + ", " + "Product: " + getProductType() + ", " + "Type: " + this.mouseType + ", " + 
	"Brand: " + getBrand() + ", " + "Colour: " + getColour() + ", " + "Connectivity: " + getConnectivity() + ", " + 
				"Quantity: " + getStockQuantity() + ", " + "Price: " + getRetailPrice() + ", " + "Buttons: " + this.buttonsTotal);
	}
}
