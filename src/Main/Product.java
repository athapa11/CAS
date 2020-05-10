package Main;


public class Product {
	private int barcode;
	private String deviceName;
	private String deviceType;
	private String brand;
	private String colour;
	private String connectivity;
	private int stockQuantity;
	private double originalCost;
	private double retailPrice;
	private String additionalInfo;
	
	
	public Product(int barcode, String deviceName, String deviceType, String brand, String colour, String connectivity, int stockQuantity, 
			double originalCost, double retailPrice, String additionalInfo)
	{
		this.barcode = barcode;
		this.deviceName = deviceName;
		this.brand = brand;
		this.colour = colour;
		this.connectivity = connectivity;
		this.stockQuantity = stockQuantity;
		this.originalCost = originalCost;
		this.retailPrice = retailPrice;
		this.deviceType = deviceType;
		this.additionalInfo = additionalInfo;
		
	}
	
	
	// Getter Methods
	public int getBarcode() {return this.barcode;}
	public String getdeviceName() {return this.deviceName;}
	public String getBrand() {return this.brand;}
	public String getColour() {return this.colour;}
	public String getConnectivity() {return this.connectivity;}
	public int getStockQuantity() {return this.stockQuantity;}
	public double getOriginalCost() {return this.originalCost;}
	public double getRetailPrice() {return this.retailPrice;}
	public String getDeviceName() {return this.deviceType;}
	public String getAdditionalInfo() {return this.additionalInfo;}
	
	public String getFormattedAdditionalInfo() {
		if(this.deviceName.equals("keyboard"))
		{
		  return "Keyboard type : " + this.deviceType + ", Keyboard layout : "+ this.additionalInfo;
		}else {
			return "Mouse type : " + this.deviceType + ", Number of buttons : "+ this.additionalInfo;
		}
	}
	
}
