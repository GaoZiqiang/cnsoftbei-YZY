package cn.edu.sdut.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the borrow_return_record database table.
 * 
 */
@Entity
@Table(name="borrow_return_record")
@NamedQuery(name="BorrowReturnRecord.findAll", query="SELECT b FROM BorrowReturnRecord b")
public class BorrowReturnRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="book_id")
	private Integer bookId;

	@Temporal(TemporalType.DATE)
	@Column(name="start_time")
	private Date startTime;

	@Column(name="stuff_id")
	private Integer stuffId;

	@Column(name="total_time")
	private String totalTime;

	//bi-directional one-to-one association to Book
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	private Book book;

	//bi-directional one-to-one association to Stuff
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	private Stuff stuff;

	public BorrowReturnRecord() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Integer getStuffId() {
		return this.stuffId;
	}

	public void setStuffId(Integer stuffId) {
		this.stuffId = stuffId;
	}

	public String getTotalTime() {
		return this.totalTime;
	}

	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
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