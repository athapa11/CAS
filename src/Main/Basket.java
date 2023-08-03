package Main;
import java.util.ArrayList;


public class Basket {
	
	private static ArrayList<BasketItem> basketItems = new ArrayList<BasketItem>();
	private static double basketTotal ;

	public int getLineItemCount() {
		return basketItems.size();
	}

	public void addBasketItem(Product product, int quantity) {
		BasketItem basketItem = new BasketItem(product, quantity);
		basketItems.add(basketItem);
		calculateTotalCostOfBasket();
	}
 
	public BasketItem removeBasketItem(int itemIndex) {
		BasketItem basketItem = null;
		if(basketItems.size()>itemIndex) {
			basketItem = basketItems.get(itemIndex);
			if(basketItem != null) {
				basketItems.remove(basketItem);
				calculateTotalCostOfBasket();
			}		
		}
		return basketItem;
	}

	public void addBasketItem(BasketItem basketItem) {
		basketItems.add(basketItem);
	}

	public BasketItem getBasketItem(int iItemIndex) {
		BasketItem basketItem = null;
		if(basketItems.size() > iItemIndex) {
			basketItem = basketItems.get(iItemIndex);
		}
		return basketItem;
	}

	public ArrayList<BasketItem> getBasketItems() {
		return basketItems;
	}
	
	public void setBasketItems(ArrayList<BasketItem> basketItem) {
		Basket.basketItems = basketItem;
	}
	
	public double getTotalCost() {
		return basketTotal;
	}
	
	public void setTotalCost(double totalCost) {
		Basket.basketTotal = totalCost;
	}
	
	// Calculate the cost of the whole basket when paying
	protected void calculateTotalCostOfBasket() {
		double totalCost = 0;
		for(int counter=0; counter<basketItems.size(); counter++) 
		{
			BasketItem basketItem = basketItems.get(counter);
			totalCost += basketItem.getTotalCostOfItem();
		}
		setTotalCost(totalCost);
	} 
}
