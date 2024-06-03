package hust.soict.dsai.aims.media;

import java.util.Comparator;
import hust.soict.dsai.aims.media.sort.*;
import hust.soict.dsai.aims.exception.*;;

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	public Media(int id, String title, String category, float cost) throws IllegalArgumentException, TitleException, CostException{
		if (title.isEmpty()) {
			throw new TitleException("Title cannot be empty or blank");
		}
		if (cost < 0) {
			throw new IllegalArgumentException("Cost cannot be negative");
		}
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Media media = (Media) obj;
		return title != null && media.getTitle().equals(this.title);
	}
	
	
}
