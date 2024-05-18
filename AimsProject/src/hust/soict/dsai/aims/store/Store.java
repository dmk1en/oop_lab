package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Media;

public class Store {
    public static final int MAX_NUMBERS_STORE = 1000;

    public static List<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media){
    	if (itemsInStore.size() < MAX_NUMBERS_STORE) {
	        itemsInStore.add(media);
	        System.out.println("Added to the store.");
    	}else {
    		System.out.println("Max storage!");
    	}
    }

    public void removeMedia(Media media){
    	if (itemsInStore.size() < MAX_NUMBERS_STORE) {
	    	itemsInStore.remove(media);
	        System.out.println("Removed from the store.");
    	}else {
    		System.out.println("Max storage!");
    	}
    	
    }
    	
    
    
    
}


