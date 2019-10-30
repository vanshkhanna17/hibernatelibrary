package Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Books {
	@Id
	@GeneratedValue
	private int id;
	
	private String title;
	private String author;
	private int price;
	
	@ElementCollection
	private Set<Reviews> review = new HashSet<Reviews>();
	
	public Books() {}
	public Books(String title, String author, String price, Set<Reviews> review) {
		super();
		this.title = title;
		this.author = author;
		this.price = Integer.parseInt(price);
		this.review = review;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Set<Reviews> getReview() {
		return review;
	}
	public void setReview(Set<Reviews> review) {
		this.review = review;
	}
	
}
