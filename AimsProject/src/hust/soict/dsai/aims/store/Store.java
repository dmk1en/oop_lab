package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    private static int qtyStore = 0;
    public static final int MAX_NUMBERS_STORE = 1000;

    public DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_STORE];

    public void addDVD( DigitalVideoDisc dvd){
        itemsInStore[qtyStore] = dvd;
        qtyStore++;
        System.out.println("Added to the store");
    }

    public void removedvd( int id ){
        boolean found = false;
        int num = 0 ;

        for ( int i=0; i < qtyStore; i++){
            if ( itemsInStore[i].isMatch(id) ){
                found = true;
                num = i;
                break;
            }
        }

        if (found == true){
            itemsInStore[num] = null;
            for ( int i = num; i < qtyStore; i ++ ){
                itemsInStore[i] = itemsInStore[i+1];
            }
            itemsInStore[qtyStore] = null;
            qtyStore--;
            
            System.out.println("DVD removed"); 
        }else{
            System.out.println("Not found dvd with id = " + String.valueOf(id));
        }
    }
}

