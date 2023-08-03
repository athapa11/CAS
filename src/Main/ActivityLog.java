package Main;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityLog {
	
	private User currentUser = null; 
	
	public ActivityLog() {
		currentUser = UserSession.getCurrentUser(); 		
	}
	
	// Update ActivityLog.txt
	public void logActivity(BasketItem item, String status, String paymentMethod)
	{
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		String currentDate = df.format(new Date());
		Product product = item.getProduct();
		String quantity = Integer.toString(item.getQuantity());
		String price = Double.toString(product.getRetailPrice());
		String logToWrite = (currentUser.userId + ", " + currentUser.postcode + ", " + product.getBarcode() + ", " + 
		price + ", " + quantity + ", " + status + ", " + paymentMethod +", "+ currentDate + "\n");	
		
		try {
			String fileName = "ActivityLog.txt";
		    FileInputStream fr = new FileInputStream(fileName);
		    DataInputStream dr = new DataInputStream(fr);

		    while (dr.available() > 0) {
		    	logToWrite += dr.readLine()+"\n";
		    }
		    dr.close();
		    fr.close();

		    FileOutputStream writer = new FileOutputStream(fileName);
		    writer.write((new String()).getBytes());
		    writer.close();

		    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
		    out.println(logToWrite);
		    out.close();

		    }catch (IOException e) {       
	            e.printStackTrace();
		    }
	}
}
