package hust.soict.dsai.aims.cart;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Cart {

    private float cost;

    public static final int MAX_NUMBERS_ORDER = 20;
    
    private ArrayList<Media> itemsOrdered = new	ArrayList<Media>();

    public void addMedia(Media media) {
    	itemsOrdered.add(media);
    }
    
    public void removeMedia(Media media) {
    	itemsOrdered.remove(media);
    }
    
    public float  totalCost() {
    	for (Media media : itemsOrdered) {
    		cost += media.getCost();
    	}
    	return cost;
    	
    }

}   
