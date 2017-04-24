package cn.edu.sdut.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String barcode;

	private String name;

	//bi-directional many-to-one association to Book
	@OneToMany(mappedBy="category")
	private Set<Book> books;

	//bi-directional one-to-one association to StockIn
	@OneToOne(mappedBy="categoryBean", fetch=FetchType.LAZY)
	private StockIn stockIn;

	public Category() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBooks() {
		return this.books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Book addBook(Book book) {
		getBooks().add(book);
		book.setCategory(this);

		return book;
	}

	public Book removeBook(Book book) {
		getBooks().remove(book);
		book.setCategory(null);

		return book;
	}

	public StockIn getStockIn() {
		return this.stockIn;
	}

	public void setStockIn(StockIn stockIn) {
		this.stockIn = stockIn;
	}

}