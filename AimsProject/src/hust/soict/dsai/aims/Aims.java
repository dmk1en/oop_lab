package hust.soict.dsai.aims;

import java.util.Collections;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	
	private static Store store = new Store(); 
    private static Cart cart = new Cart();
    private static Scanner sc = new Scanner(System.in);
	
	public static void showMenu() {
    	System.out.println("AIMS: ");
    	System.out.println("--------------------------------");
    	System.out.println("1. View store");
    	System.out.println("2. Update store");
    	System.out.println("3. See current cart");
    	System.out.println("0. Exit");
    	System.out.println("--------------------------------");
    	System.out.println("Please choose a number: 0-1-2-3");
    	
    	String userInput = sc.nextLine();
    	switch(userInput) {
    		case "1":
    			storeMenu();
    			break;
    		case "2":
    			UpdateStore();
    			break;
    		case "3":
    			cartMenu();
    			break;
    		case "4":
    			break;
    		case "0":
    			break;
    		default:
    			break;
    	}
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
    	
 
    	String userInput = sc.nextLine();
    	
    	switch(userInput) {
		case "1":
			System.out.println("Enter the title:");
	    	String userTitleInput = sc.nextLine();
	    	boolean found = false;
	    	for (Media media : store.itemsInStore ) {
	    		if (media.getTitle().equals(userTitleInput)) {
	    			//media.toString();
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

    	
    }
    
    public static void mediaDetailsMenu(Media media) {
    	System.out.println("Options: ");
    	System.out.println("--------------------------------");
    	System.out.println("1. Add to cart");
    	System.out.println("2. Play");
    	System.out.println("0. Back");
    	System.out.println("--------------------------------");
    	System.out.println("Please choose a number: 0-1-2");

    	String mediaDetailsMenuUserInput = sc.nextLine();
    	switch(mediaDetailsMenuUserInput) {
		case "1":
			cart.addMedia(media);
			System.out.println("The number of media in cart: " + cart.getItemsOrdered().size());
			
			break;
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
			
			break;
		case "0":
			storeMenu();
		default:
			break;
    	}
    	mediaDetailsMenu(media);
    }
  
    public static void UpdateStore() {
    	System.out.println("Options: ");
    	System.out.println("--------------------------------");
    	System.out.println("1. Add a media");
    	System.out.println("2. Remove a media");
    	System.out.println("0. Back");
    	System.out.println("--------------------------------");
    	System.out.println("Please choose a number: 0-1-2");
    	
    	String UpdateStoreUserInput = sc.nextLine();
    	switch(UpdateStoreUserInput) {
    		case "1":
    			AddMedia();
    			break;
    		case "2":
    			RemoveMedia();
    			break;
    		case "0":
    			showMenu();
    			break;

    		default:
    			UpdateStore();
    			break;
    	}
    }
    
    public static void AddMedia() {
    	System.out.println("Type: ");
    	System.out.println("--------------------------------");
    	System.out.println("1. Book");
    	System.out.println("2. DVD");
    	System.out.println("3. CD");
    	System.out.println("0. Back");
    	System.out.println("--------------------------------");
    	System.out.println("Please choose a number: 0-1-2");
    	
    	String AddMediaUserInput = sc.nextLine();
    	
    	System.out.println("Enter attribute of media: ");
    	System.out.println("--------------------------------");
    	System.out.println("Enter id: ");
    	int id = sc.nextInt();
    	sc.nextLine();
    	System.out.println("Enter title: ");
    	String title = sc.nextLine();
    	System.out.println("Enter category: ");
    	String category = sc.nextLine();
    	System.out.println("Enter cost: ");
    	float cost = sc.nextFloat();
    	sc.nextLine();
    	
    	switch(AddMediaUserInput) {
    		case "1":
    			store.addMedia(new Book(id,title,category,cost));
    		
    			break;
    		case "2":
    			System.out.println("Enter length: ");
    			float DVDlength = sc.nextFloat();
    			sc.nextLine();
    			System.out.println("Enter director: ");
    			String DVDdirector = sc.nextLine();
    			store.addMedia(new DigitalVideoDisc(id,title,category,cost,DVDlength,DVDdirector));
    		
    			break;
    		case "3":
    			System.out.println("Enter length: ");
    			float CDlength = sc.nextFloat();
    			sc.nextLine();
    			System.out.println("Enter director: ");
    			String CDdirector = sc.nextLine();
    			System.out.println("Enter artist: ");
    			String CDartist = sc.nextLine();
    			store.addMedia(new CompactDisc(id,title,category,cost,CDlength,CDdirector,CDartist));
    		
    			break;
    		case "0":
    			UpdateStore();
    			break;
    		default:
    			AddMedia();
    			break;
    	}
    	UpdateStore();
    	
    }
    
	public static void RemoveMedia() {
		System.out.println("--------------------------------");
		System.out.println("Enter title of the media you want to remove: ");
		String title = sc.nextLine();
		for (Media media : store.itemsInStore) {
			if (media.getTitle().equals(title)) {
				store.removeMedia(media);
				break;
			}
		}
		UpdateStore();
	}
    
	public static void cartMenu() {
    	cart.listingCart();
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
    	
    	String cartMenuUserInput = sc.nextLine();
    	switch(cartMenuUserInput) {
    		case "1":
    			filterMediaInCart();
    			break;
    		case "2":
    			sortMediaInCart();
    			break;
    		case "3":
    			break;
    		case "4":
    			break;
    		case "5":
    			placeOder();
    			break;
    		case "0":
    			showMenu();
    			break;
    		default:
    			break;
    	}
    }
    
	public static void filterMediaInCart() {
		System.out.println("Filter options: ");
    	System.out.println("--------------------------------");
    	System.out.println("1. By id");
    	System.out.println("2. By title");
    	System.out.println("0. Back");
    	
    	String filterMediaInCartUserInput = sc.nextLine();
    	System.out.println("--------------------------------");
    	switch(filterMediaInCartUserInput) {
    		case "1":
    			System.out.println("Enter ID: ");
    			int filterID = sc.nextInt();
    			sc.nextLine();
    			for (Media media : cart.getItemsOrdered()) {
    				if (media.getId() == filterID ) {
    					System.out.println("Found!");
    					System.out.println(media.toString());
    					break;
    				}
    			}
    			break;
    		case "2":
    			System.out.println("Enter title: ");
    			String filterTitle = sc.nextLine();
    			for (Media media : cart.getItemsOrdered()) {
    				if (media.getTitle().equals(filterTitle) ) {
    					System.out.println("Found!");
    					System.out.println(media.toString());
    					break;
    				}
    			}
    			break;
    		case "0":
    			cartMenu();
    			break;
    		default:
    			break;
    	}
    	cartMenu();
    	
	}
	
	public static void sortMediaInCart() {
		System.out.println("Sort options: ");
    	System.out.println("--------------------------------");
    	System.out.println("1. By title");
    	System.out.println("2. By cost");
    	System.out.println("0. Back");
    	
    	String sortMediaInCartUserInput = sc.nextLine();
    	System.out.println("--------------------------------");
    	switch(sortMediaInCartUserInput) {
    		case "1":
    			Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
    			break;
    		case "2":
    			Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
    			break;
    		case "0":
    			cartMenu();
    			break;
    		default:
    			break;
    	}
    	cartMenu();
	}
	
	public static void placeOder() {
		System.out.println("An order is created.");
		cart = new Cart();
		showMenu();
	}
	
    public static void main(String[] args) {
    	Book book = new Book(1,"Harry Porsche","Magic",10);
    	DigitalVideoDisc DVD1 = new DigitalVideoDisc(2,"Badman","Bad",20,60,"dmk");
    	DigitalVideoDisc DVD2 = new DigitalVideoDisc(3,"Goodman","Good",30,60,"dmk");
    	DigitalVideoDisc DVD3 = new DigitalVideoDisc(4,"Mediumman","Medium",30,60,"dmk");
    	
    	store.addMedia(book);
    	store.addMedia(DVD1);
    	store.addMedia(DVD2);
    	store.addMedia(DVD3);

    	showMenu();
    }
} 
