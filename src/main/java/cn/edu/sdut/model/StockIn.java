package cn.edu.sdut.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the stock_in database table.
 * 
 */
@Entity
@Table(name="stock_in")
@NamedQuery(name="StockIn.findAll", query="SELECT s FROM StockIn s")
public class StockIn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String barcode;

	@Column(name="book_id")
	private Integer bookId;

	private String category;

	@Column(name="category_id")
	private Integer categoryId;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name="librarion_name")
	private String librarionName;

	private String name;

	private Integer num;

	@Column(name="stuff_id")
	private Integer stuffId;

	//bi-directional one-to-one association to Book
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	private Book book;

	//bi-directional one-to-one association to Category
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	private Category categoryBean;

	//bi-directional one-to-one association to Stuff
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	private Stuff stuff;

	public StockIn() {
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

	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLibrarionName() {
		return this.librarionName;
	}

	public void setLibrarionName(String librarionName) {
		this.librarionName = librarionName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getStuffId() {
		return this.stuffId;
	}

	public void setStuffId(Integer stuffId) {
		this.stuffId = stuffId;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Category getCategoryBean() {
		return this.categoryBean;
	}

	public void setCategoryBean(Category categoryBean) {
		this.categoryBean = categoryBean;
	}

	public Stuff getStuff() {
		return this.stuff;
	}

	public void setStuff(Stuff stuff) {
		this.stuff = stuff;
	}

}