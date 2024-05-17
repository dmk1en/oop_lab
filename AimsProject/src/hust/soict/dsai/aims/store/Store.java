package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
    private static int qtyStore = 0;
    public static final int MAX_NUMBERS_STORE = 1000;

    public ArrayList<Media> itemsInStore;

    public void addMedia(Media media){
        itemsInStore.add(media);
        qtyStore++;
        System.out.println("Added to the store");
    }

    public void removeMedia(Media media){
    	itemsInStore.remove(media);
    	qtyStore--;
        System.out.println("Removed from the store");
    }
}

