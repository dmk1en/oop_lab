package hust.soict.dsai.test.disc;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.*;

public class Polymorphism {

	public static void main(String[] args) {
		Book book = new Book(1,"How to train dragon","scam",10);
		DigitalVideoDisc DVD = new DigitalVideoDisc(1,"How to train dog","comedy",20,60,"dmk");
		CompactDisc CD = new CompactDisc(1,"How to train dog","comedy",20,60,"dmk","dmk1en");
		
		List<Media> media = new ArrayList<Media>();
		
		media.add(book);
		media.add(DVD);
		media.add(CD);
		
		for (Media m : media) {
			//each type of Media has its own toString() method 
			//so it will perform that method
			System.out.println(m.toString());
		}
	}
}
