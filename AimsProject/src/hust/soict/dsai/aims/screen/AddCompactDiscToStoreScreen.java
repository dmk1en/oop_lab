package hust.soict.dsai.aims.screen;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.CostException;
import hust.soict.dsai.aims.exception.TitleException;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.CompactDisc;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen{
    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
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
        addLabelAndTextField(center, constraints, "Enter a Artist: ", 6);

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
                String artist = getTextFromTextField(center, 6);
                CompactDisc cd;
                cd = new CompactDisc(id, title, category, cost,length, director, artist);
                System.out.println(cd.toString());
                store.addMedia(cd);
            } catch (IllegalArgumentException | TitleException | CostException e1) {
                e1.printStackTrace();
            }

        });
        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.gridwidth = 2;
        center.add(button, constraints);

        return center;
    }
}
