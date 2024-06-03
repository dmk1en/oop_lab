package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.LimitExceededException;
import javax.swing.*;

import hust.soict.dsai.aims.media.*;
import javafx.application.Platform;
import hust.soict.dsai.aims.cart.Cart;

public class MediaStore extends JPanel {
	private Media media;
	private Cart cart;

	public MediaStore (Media media, Cart cart) {
		this.cart = cart;
		this.media = media;
		this.setLayout(new BoxLayout( this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel (media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20)); 
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+media.getCost()+" $"); 
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout (FlowLayout.CENTER));
		
		JButton btnAddToCart = new JButton("Add to cart");
		btnAddToCart.addActionListener(new ButtonListener());
		container.add(btnAddToCart); 
		if(media instanceof Playable) {
			JButton btnPlay =  new JButton("Play");
			btnPlay.addActionListener(new ButtonListener());
			container.add(btnPlay);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title); 
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	private class ButtonListener implements ActionListener{ 
		@Override
		public void actionPerformed (ActionEvent e) {
			String button = e.getActionCommand();
			switch (button) {
			case "Play":
				play();
				break;
			case "Add to cart":
				SwingUtilities.invokeLater(() -> {
					Platform.runLater(() -> {
						try {
							cart.addMedia(media);
						} catch (LimitExceededException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					});
				});
				
			}
			
		}
	}
	
	public void play() {
		
		JDialog playDialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Play Media", true);
		playDialog.setSize(300, 150);
		JLabel title = new JLabel("Playing: " + media.getTitle(), SwingConstants.CENTER);
        playDialog.add(title, BorderLayout.CENTER);
		playDialog.setVisible(true);
		
	}
	
}
