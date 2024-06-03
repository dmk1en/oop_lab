package hust.soict.dsai.aims.cart;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {

    public static final int MAX_NUMBERS_ORDER = 20;
    
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    
    public ObservableList<Media> getItemsOrdered(){
    	return itemsOrdered;
    }

    public void addMedia(Media media) throws LimitExceededException {
    	if (itemsOrdered.size() < MAX_NUMBERS_ORDER) {
    		itemsOrdered.add(media);
    		System.out.println("Added to the cart.");
    	}else {
    		throw new LimitExceededException("ERROR: The number of media has reached its limit");
    	}
    }
    
    public void removeMedia(Media media) {
    	if (itemsOrdered.size() <= MAX_NUMBERS_ORDER) {
    		itemsOrdered.remove(media);
    		System.out.println("Removed from the cart.");
    	}else {
    		System.out.println("Full capacity of cart!");
    	}
    }
    
    public float totalCost() {
    	float cost = 0;
    	for (Media media : itemsOrdered) {
    		cost += media.getCost();
    	}
    	return cost;
    	
    }

    public void clear() {
        itemsOrdered.clear();
    }

    public void listingCart(){
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        int i = 1;
        for (Media media : itemsOrdered){
            System.out.println(String.valueOf(i) + ". " + media.toString());
            i++;
        }
        System.out.println("Total Cost: " + String.valueOf(totalCost()) + " $");
        

        System.out.println("***************************************************");

    }
}   
