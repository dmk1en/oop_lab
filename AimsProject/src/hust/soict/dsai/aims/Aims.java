package hust.soict.dsai.aims;

import java.util.Arrays;
import java.util.List;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.CostException;
import hust.soict.dsai.aims.exception.TitleException;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	private static Store store = new Store(); 
    private static Cart cart = new Cart();
	
    public static void main(String[] args) throws LimitExceededException,IllegalArgumentException {
        try {
            Book book1 = new Book(1,"Harry Porsche","Magic",10);
            Book book2 = new Book(5, "The Life of Pi(e)", "Comedy", 15);
            Book book3 = new Book(11, "Game of Scones", "Comedy", 20);
            DigitalVideoDisc DVD1 = new DigitalVideoDisc(2,"Badman","Bad",20,60,"dmk");
            DigitalVideoDisc DVD2 = new DigitalVideoDisc(12, "Prawn of the Dead", "Comedy", 75, 110, "Seafood Zombies");
            DigitalVideoDisc DVD3 = new DigitalVideoDisc(4, "The Silence of the Yams", "Comedy", 15, 100, "Vegetable Horror");
            DigitalVideoDisc DVD4 = new DigitalVideoDisc(6, "The Codfather", "Comedy", 25, 120, "Fish Mafia");
            DigitalVideoDisc DVD5 = new DigitalVideoDisc(7, "Jurassic Pork", "Comedy", 35, 90, "Dinosaur Pigs");
            DigitalVideoDisc DVD6 = new DigitalVideoDisc(8, "Star Warts", "Comedy", 45, 140, "Space Diseases");
            DigitalVideoDisc DVD7 = new DigitalVideoDisc(9, "Lord of the Fries", "Comedy", 55, 180, "Fast Food Adventure");
            DigitalVideoDisc DVD8 = new DigitalVideoDisc(10, "Harry Potter and the Goblet of Fire Ants", "Comedy", 65, 150, "Insect Magic");

            List<Media> storeMedia = Arrays.asList(book1,book2,book3,DVD1,DVD2,DVD3, DVD4, DVD5, DVD6, DVD7, DVD8);
            List<Media> cartMedia = Arrays.asList(book1, DVD1, DVD2, DVD3);
            for (Media media : storeMedia) {
                store.addMedia(media);
            }
            for (Media media : cartMedia) {
                cart.addMedia(media);
            }
            StoreScreen storeScreen = new StoreScreen(store, cart);
        } catch (IllegalArgumentException | TitleException | CostException e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
} 
