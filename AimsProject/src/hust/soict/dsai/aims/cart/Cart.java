package hust.soict.dsai.aims.cart;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Cart {

    public static final int MAX_NUMBERS_ORDER = 20;
    
    private ArrayList<Media> itemsOrdered = new	ArrayList<Media>();
    
    public ArrayList<Media> getItemsOrdered(){
    	return itemsOrdered;
    }

    public void addMedia(Media media) {
    	if (itemsOrdered.size() < MAX_NUMBERS_ORDER) {
    		itemsOrdered.add(media);
    		System.out.println("Added to the cart.");
    	}else {
    		System.out.println("Full capacity of cart!");
    	}
    }
    
    public void removeMedia(Media media) {
    	if (itemsOrdered.size() < MAX_NUMBERS_ORDER) {
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
