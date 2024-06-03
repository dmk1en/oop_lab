package hust.soict.dsai.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;


public class CartScreen extends JFrame{ 
	private Cart cart;
	private Store store;

	public CartScreen(Cart cart,Store store) { 
		super();
		
		this.cart = cart;
		this.store = store;
		
		JFXPanel fxPanel = new JFXPanel(); 
		this.add(fxPanel);
		
		this.setTitle("Cart"); 
		this.setVisible(false);
		Platform.runLater (new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
					CartScreenController controller = new CartScreenController(cart,store,fxPanel);
					loader.setController(controller); 
					Parent root = loader.load(); 
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) {
		CartScreen cartScreen = new CartScreen(new Cart(),new Store());
		cartScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cartScreen.setSize(1024, 768);
		cartScreen.setVisible(true);
	}
}