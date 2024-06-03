package hust.soict.dsai.aims.screen;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartScreenController {
	private Cart cart;
	private Store store;
	private JFXPanel jfxPanel;

	@FXML
	private TableView<Media> tblMedia;
	
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	
	@FXML
	private TableColumn<Media, String> colMediacategory;
	
	@FXML
	private TableColumn<Media, Float> colMediaCost;

	@FXML
	private Button btnRemove;

	@FXML
	private Button btnPlay;

	@FXML
	private Button btnPlaceOrder;

	@FXML
	private Label lblTotalCost;

	@FXML
	private MenuItem viewStore;
	
	public CartScreenController(Cart cart,Store store,JFXPanel fxPanel) {
		super();
		this.cart = cart;
		this.store = store;
		this.jfxPanel = fxPanel;
	}
	
	@FXML
	private void initialize() {
		colMediaTitle.setCellValueFactory(
				new PropertyValueFactory<Media, String>("title"));
		colMediacategory.setCellValueFactory(
				new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(
				new PropertyValueFactory<Media, Float>("cost")); 
		tblMedia.setItems(this.cart.getItemsOrdered());

		this.btnPlay.setVisible(false);
		this.btnRemove.setVisible(false);

		lblTotalCost.setText(cart.totalCost() + "$");

		cart.getItemsOrdered().addListener(
			new ListChangeListener<Media>() {
				@Override
				public void onChanged(Change<? extends Media> c) {
					lblTotalCost.setText(cart.totalCost() + "$");
				}
			}
		);
		

		tblMedia.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<Media>() {

				@Override
				public void changed(ObservableValue<? extends Media > observable, Media oldValue, Media newValue) {
					if (newValue != null) {
						updateButtonBar(newValue);
					}
				}
			}
		);

	}

	void updateButtonBar(Media media){
		btnRemove.setVisible(true);
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		} else {
			btnPlay.setVisible(false);
		}
	}

	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
	}

	@FXML
	void btnPlayPressed(ActionEvent event) throws PlayerException {
		Playable media = (Playable) tblMedia.getSelectionModel().getSelectedItem();
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Play");
		alert.setHeaderText(null);
		alert.setContentText(media.play());
		alert.showAndWait();
	}

	@FXML
	void btnPlaceOrderPressed(ActionEvent event) {
		cart.clear();
	}

	@FXML
	void viewStorePressed(ActionEvent event) {
		StoreScreen storeScreen = new StoreScreen(store,cart);
		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(jfxPanel);
		frame.setVisible(false);
		frame.dispose();
	}
}