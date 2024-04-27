package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
    private int qtyOrdered;
    private float cost;

    public static final int MAX_NUMBERS_ORDER = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDER];
    

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (qtyOrdered >=20 ){
            System.out.println("The cart is almost full");
        }
        else{
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered += 1;
            System.out.println("The disc has been added");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList){
        for ( DigitalVideoDisc n : dvdList ){
            addDigitalVideoDisc(n);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2){
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed.");
                return;
            }
        }
        System.out.println("The disc was not found in the cart.");
    }

    public float totalCost(){
        for (int i = 0; i < qtyOrdered; i++){
            cost += itemsOrdered[i].getCost();
        }
        return cost;
    }

    public void listingCart(){
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        for ( int i = 0 ; i < qtyOrdered ; i++){
            System.out.println(String.valueOf(i) + ". " + itemsOrdered[i].toString());
        }

        System.out.println("***************************************************");

    }

    public void id_DVD_search(int id){
        boolean found = false;
        int num = 0 ;

        for ( int i=0; i < qtyOrdered; i++){
            if ( itemsOrdered[i].isMatch(id) ){
                found = true;
                num = i;
                break;
            }
        }

        if (found == true){
            System.out.println(itemsOrdered[num].toString()); 
        }else{
            System.out.println("Not found item with id = " + String.valueOf(id));
        }
    }

    public void title_DVD_search(String title){
        boolean found = false;
        int num = 0 ;

        for ( int i=0; i < qtyOrdered; i++){
            if ( itemsOrdered[i].getTitle() == title ){
                found = true;
                num = i;
                break;
            }
        }

        if (found == true){
            System.out.println(itemsOrdered[num].toString()); 
        }else{
            System.out.println("Not found item with title '" + String.valueOf(title) + "'");
        }
    }



}   
