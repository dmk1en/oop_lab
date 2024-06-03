package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

abstract class BaseScreen extends JFrame {
    public Store store;
    public Cart cart;

    public BaseScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setSize(1024,768);	
		
	}
	
	private JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		
		return north;
	}
	
	private JMenuBar createMenuBar() {
		JMenu menu= new JMenu("Options");
		JMenu smUpdateStore = new JMenu("Update Store"); 

		JMenuItem addBook = new JMenuItem("Add Book");
		addBook.addActionListener(e -> {
			AddItemToStoreScreen addBookScreen = new AddBookToStoreScreen(store, cart);
			addBookScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			addBookScreen.setSize(1024, 768);
			BaseScreen.this.setVisible(false);
			addBookScreen.setVisible(true);
		});

		smUpdateStore.add(addBook); 

		JMenuItem addCD = new JMenuItem("Add CD");
		addCD.addActionListener(e -> {
			AddItemToStoreScreen addCDScreen = new AddCompactDiscToStoreScreen(store, cart);
			addCDScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			addCDScreen.setSize(1024, 768);
			BaseScreen.this.setVisible(false);
			addCDScreen.setVisible(true);
		});

		smUpdateStore.add(addCD);

		JMenuItem addDVD = new JMenuItem("Add DVD");
		addDVD.addActionListener(e -> {
			AddItemToStoreScreen addDVDScreen = new AddDigitalVideoDiscToStoreScreen(store, cart);
			addDVDScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			addDVDScreen.setSize(1024, 768);
			BaseScreen.this.setVisible(false);
			addDVDScreen.setVisible(true);
		});

		smUpdateStore.add(addDVD);
		
		menu.add(smUpdateStore);

		JMenuItem viewStore = new JMenuItem("View store");
		
		viewStore.addActionListener(e -> {
			StoreScreen StoreScreen = new StoreScreen(store, cart);
			StoreScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			StoreScreen.setSize(1024, 768);
			BaseScreen.this.setVisible(false);
			StoreScreen.setVisible(true);
		});

		menu.add(viewStore); 

		JMenuItem viewCart = new JMenuItem("View cart");
		viewCart.addActionListener(e -> {
			CartScreen cartScreen = new CartScreen(cart, store);
			cartScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			cartScreen.setSize(1024, 768);
			BaseScreen.this.setVisible(false);
			cartScreen.setVisible(true);
		});

		menu.add(viewCart);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout (FlowLayout.LEFT)); 
		menuBar.add(menu);
		return menuBar;
	}

	private JPanel createHeader() {

		CartScreen cartScreen = new CartScreen(cart, store);

		JPanel header = new JPanel();
		header.setLayout (new BoxLayout (header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font. PLAIN, 50)); 
		title.setForeground (Color.CYAN);
		
		JButton cartButton = new JButton("View cart"); 
		cartButton.setPreferredSize (new Dimension (100, 50)); 
		cartButton.setMaximumSize (new Dimension (100, 50));
		cartButton.addActionListener(e -> showCartScreen(e,cartScreen));

		header.add(Box.createRigidArea (new Dimension (10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cartButton);
		header.add(Box.createRigidArea (new Dimension (10, 10)));
		
		return header;
	}

    private void showCartScreen(ActionEvent e,CartScreen cartScreen) {
        cartScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cartScreen.setSize(1024, 768);
        BaseScreen.this.setVisible(false);
        cartScreen.setVisible(true);
    }

    abstract JPanel createCenter();

}
