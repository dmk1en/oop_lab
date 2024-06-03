package hust.soict.dsai.aims.screen;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;


abstract class AddItemToStoreScreen extends BaseScreen{
    public AddItemToStoreScreen(Store store, Cart cart) {
        super(store,cart);
        setTitle("Add Item to Store");
    }
    protected void addLabelAndTextField(JPanel center, GridBagConstraints constraints, String labelText, int gridy) {
        JLabel label = new JLabel(labelText);
        constraints.gridx = 0;
        constraints.gridy = gridy;
        constraints.fill = GridBagConstraints.HORIZONTAL; 
        
        center.add(label, constraints);
    
        JTextField textField = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = gridy;
        
        center.add(textField, constraints);
    }
    
    protected String getTextFromTextField(JPanel center, int gridy) {
        JTextField textField = (JTextField) center.getComponent(gridy * 2 + 1);
        return textField.getText();
    }

    
}
