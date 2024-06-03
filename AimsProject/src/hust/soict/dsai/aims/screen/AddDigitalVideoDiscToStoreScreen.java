package hust.soict.dsai.aims.screen;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.CostException;
import hust.soict.dsai.aims.exception.TitleException;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart);
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel();
        GridBagLayout gridLayout = new GridBagLayout();
        center.setLayout(gridLayout);
        GridBagConstraints constraints = new GridBagConstraints();

        addLabelAndTextField(center, constraints, "Enter an Id: ", 0);
        addLabelAndTextField(center, constraints, "Enter a Title: ", 1);
        addLabelAndTextField(center, constraints, "Enter a Category: ", 2);
        addLabelAndTextField(center, constraints, "Enter a Cost: ", 3);
        addLabelAndTextField(center, constraints, "Enter a Length: ", 4);
        addLabelAndTextField(center, constraints, "Enter a Director: ", 5);

        JButton button = new JButton("Add Item");
        button.addActionListener(e -> {
            try {
                Integer id = Integer.parseInt(getTextFromTextField(center, 0));
                String title = getTextFromTextField(center, 1);
                System.out.println(title);
                String category = getTextFromTextField(center, 2);
                float cost = Float.parseFloat(getTextFromTextField(center, 3));
                float length = Float.parseFloat(getTextFromTextField(center, 4));
                String director = getTextFromTextField(center, 5);
                DigitalVideoDisc dvd;
                dvd = new DigitalVideoDisc(id, title, category, cost, length, director);
                System.out.println(dvd.toString());
                store.addMedia(dvd);
            } catch (IllegalArgumentException | TitleException | CostException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        });
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        center.add(button, constraints);

        return center;
    }


}
