package cn.edu.sdut.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="book_type")
	private String bookType;

	private String flag;

	@Temporal(TemporalType.DATE)
	@Column(name="time_check")
	private Date timeCheck;

	//bi-directional many-to-one association to Book
	@ManyToOne(fetch=FetchType.LAZY)
	private Book book;

	//bi-directional many-to-one association to Stuff
	@ManyToOne(fetch=FetchType.LAZY)
	private Stuff stuff;

	public Account() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookType() {
		return this.bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Date getTimeCheck() {
		return this.timeCheck;
	}

	public void setTimeCheck(Date timeCheck) {
		this.timeCheck = timeCheck;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Stuff getStuff() {
		return this.stuff;
	}

	public void setStuff(Stuff stuff) {
		this.stuff = stuff;
	}

}