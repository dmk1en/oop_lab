package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.*;

public class Store {
    public static final int MAX_NUMBERS_STORE = 1000;

    public  List<Media> itemsInStore = new ArrayList<>();

    public  void addMedia(Media media){
    	if (itemsInStore.size() < MAX_NUMBERS_STORE) {
			boolean check = true;
			for (Media item : itemsInStore) {
				if (item.equals(media)) {
					System.out.println("This item is already in the store.");
					check = false;
					return;
				}
			}
			if (check) {
				itemsInStore.add(media);
				System.out.println("Added to the store.");
			}
    	}else {
    		System.out.println("Max storage!");
    	}
    }

    public  void removeMedia(Media media){
    	if (itemsInStore.size() <= MAX_NUMBERS_STORE) {
	    	itemsInStore.remove(media);
	        System.out.println("Removed from the store.");
    	}else {
    		System.out.println("Max storage!");
    	}
    	
    }

	public List<Media> getItemsInStore() {
		return itemsInStore;
	}
    
    // public static void main(String[] args) {
	// 	Store store = new Store();
	// 	Book book1 = new Book(1,"Harry Porsche","Magic",10);
	// 	Book book2 = new Book(2,"Harry Porsche","Magic",10);
	// 	DigitalVideoDisc DVD1 = new DigitalVideoDisc(2,"Harry Porsche","Bad",20,60,"dmk");

	// 	store.addMedia(book1);
	// 	store.addMedia(DVD1);
	// }
    
}


