package hust.soict.dsai.aims;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	
	private static Store store = new Store(); 
    private static Cart cart = new Cart();
	
	public static void showMenu() {
    	System.out.println("AIMS: ");
    	System.out.println("--------------------------------");
    	System.out.println("1. View store");
    	System.out.println("2. Update store");
    	System.out.println("3. See current cart");
    	System.out.println("0. Exit");
    	System.out.println("--------------------------------");
    	System.out.println("Please choose a number: 0-1-2-3");
    	Scanner input = new Scanner(System.in);
    	String userInput = input.nextLine();
    	switch(userInput) {
    		case "1":
    			storeMenu();
    		case "2":
    			break;
    		case "3":
    			break;
    		case "4":
    			break;
    		case "0":
    			break;
    		default:
    			break;
    	}
    	
    	
    	input.close();
    }
    
    public static void storeMenu() {
    	System.out.println("Options: ");
    	System.out.println("--------------------------------");
    	System.out.println("1. See a media’s details");
    	System.out.println("2. Add a media to cart");
    	System.out.println("3. Play a media");
    	System.out.println("4. See current cart");
    	System.out.println("0. Back");
    	System.out.println("--------------------------------");
    	System.out.println("Please choose a number: 0-1-2-3-4");
    	
    	Scanner input = new Scanner(System.in);
    	String userInput = input.nextLine();
    	switch(userInput) {
		case "1":
			System.out.println("Enter the title:");
			Scanner inputTitle = new Scanner(System.in);
	    	String userTitleInput = input.nextLine();
	    	inputTitle.close();
	    	boolean found = false;
	    	for (Media media : Store.itemsInStore ) {
	    		if (media.getTitle().equals(userTitleInput)) {
	    			media.toString();
	    			mediaDetailsMenu(media);
	    			found = true;
	    		}
	    	}
			if (!found) {
				System.out.println("Not found!");
				storeMenu();
			}
			
		case "2":
			break;
		case "3":
			break;
		case "4":
			cartMenu();
		case "0":
			showMenu();
		default:
			break;
	}
    	input.close();
    	
    }
    
    public static void mediaDetailsMenu(Media media) {
    	System.out.println("Options: ");
    	System.out.println("--------------------------------");
    	System.out.println("1. Add to cart");
    	System.out.println("2. Play");
    	System.out.println("0. Back");
    	System.out.println("--------------------------------");
    	System.out.println("Please choose a number: 0-1-2");
    	
    	Scanner input = new Scanner(System.in);
    	String userInput = input.nextLine();
    	switch(userInput) {
		case "1":
			cart.addMedia(media);
		case "2":
			if (media instanceof Book) {
				System.out.println("Cann't play book!");
			}else {
				if (media instanceof DigitalVideoDisc) {
					DigitalVideoDisc dvd = (DigitalVideoDisc) media;
					dvd.play();
				}
				if (media instanceof CompactDisc) {
					CompactDisc dvd = (CompactDisc) media;
					dvd.play();
				}
			}
			mediaDetailsMenu(media);
		case "0":
			storeMenu();
		default:
			break;
	}
    	input.close();
    	
    }
    
    public static void cartMenu() {
    	System.out.println("Options: ");
    	System.out.println("--------------------------------");
    	System.out.println("1. Filter medias in cart");
    	System.out.println("2. Sort medias in cart");
    	System.out.println("3. Remove media from cart");
    	System.out.println("4. Play a media");
    	System.out.println("5. Place order");
    	System.out.println("0. Back");
    	System.out.println("--------------------------------");
    	System.out.println("Please choose a number: 0-1-2-3-4-5");
    }
	
    public static void main(String[] args) {
    	Book book = new Book(1,"Harry Porsche","Magic",10);
    	DigitalVideoDisc DVD1 = new DigitalVideoDisc(2,"Badman","Bad",20,60,"dmk");
    	DigitalVideoDisc DVD2 = new DigitalVideoDisc(3,"Goodman","Good",20,60,"dmk");
    	
    	store.addMedia(book);
    	store.addMedia(DVD1);
    	store.addMedia(DVD2);
    	
    	
    	
    	
    	showMenu();
    }
} 
