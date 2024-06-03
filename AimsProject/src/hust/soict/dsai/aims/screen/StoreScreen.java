package hust.soict.dsai.aims.screen;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;

public class StoreScreen extends BaseScreen {

	public StoreScreen(Store store, Cart cart) {
		super(store, cart);
		setTitle("Store");
	}

	@Override
	public JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3,3,2,2));
		
		ArrayList<Media> mediaInStore = (ArrayList<Media>) store.getItemsInStore();
		for (int i = 0; i<9; i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i),cart);
			center.add(cell);
		}
	
		return center;
	}
	
}
