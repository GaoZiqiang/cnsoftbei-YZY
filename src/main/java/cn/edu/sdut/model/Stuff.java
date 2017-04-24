package cn.edu.sdut.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the stuff database table.
 * 
 */
@Entity
@NamedQuery(name="Stuff.findAll", query="SELECT s FROM Stuff s")
public class Stuff implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String college;

	private String email;

	private String identity;

	private String major;

	private String name;

	private String password;

	@Column(name="phone_num")
	private String phoneNum;

	@Column(name="real_name")
	private String realName;

	@Column(name="stu_no")
	private Integer stuNo;

	//bi-directional many-to-one association to Book
	@OneToMany(mappedBy="stuff")
	private Set<Book> accounts;

	//bi-directional many-to-one association to Book
	@OneToMany(mappedBy="stuff")
	private Set<Book> books;

	//bi-directional one-to-one association to BorrowReturnRecord
	@OneToOne(mappedBy="stuff", fetch=FetchType.LAZY)
	private BorrowReturnRecord borrowReturnRecord;

	//bi-directional one-to-one association to StockIn
	@OneToOne(mappedBy="stuff", fetch=FetchType.LAZY)
	private StockIn stockIn;

	public Stuff() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCollege() {
		return this.college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentity() {
		return this.identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getStuNo() {
		return this.stuNo;
	}

	public void setStuNo(Integer stuNo) {
		this.stuNo = stuNo;
	}

	public Set<Book> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(Set<Book> accounts) {
		this.accounts = accounts;
	}

	public Book addAccount(Book account) {
		getAccounts().add(account);
		account.setStuff(this);

		return account;
	}

	public Book removeAccount(Book account) {
		getAccounts().remove(account);
		account.setStuff(null);

		return account;
	}

	public Set<Book> getBooks() {
		return this.books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Book addBook(Book book) {
		getBooks().add(book);
		book.setStuff(this);

		return book;
	}

	public Book removeBook(Book book) {
		getBooks().remove(book);
		book.setStuff(null);

		return book;
	}

	public BorrowReturnRecord getBorrowReturnRecord() {
		return this.borrowReturnRecord;
	}

	public void setBorrowReturnRecord(BorrowReturnRecord borrowReturnRecord) {
		this.borrowReturnRecord = borrowReturnRecord;
	}

	public StockIn getStockIn() {
		return this.stockIn;
	}

	public void setStockIn(StockIn stockIn) {
		this.stockIn = stockIn;
	}

}