package cn.edu.sdut.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;//注意是这个
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@RequestScoped
@ManagedBean(name = "controller")
public class DBController {

	public void connectDB() {
		System.out.println("start!");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("yueziyou");
		EntityManager em = emf.createEntityManager();
		System.out.println("打印输emf: " + emf.toString());
		System.out.println("打印输em: " + em.toString());
	}
	/*
	 * EntityManagerFactory emf = null; EntityManager em = null;
	 * 
	 * private Book testBook = new Book();
	 * 
	 * public Book getTestBook() { return testBook; }
	 * 
	 * public void setTestBook(Book testBook) { this.testBook = testBook; }
	 * 
	 * public void connectDB() { try { emf =
	 * Persistence.createEntityManagerFactory("yueziyou"); em =
	 * emf.createEntityManager();
	 * 
	 * // 开启事务 em.getTransaction().begin(); testBook.setName("testBook");
	 * System.out.println("打印emf: " + emf.toString());
	 * System.out.println("打印em: "+ em.toString()); em.persist(testBook); //
	 * 关闭事务 em.getTransaction().commit(); } catch (Exception e) {
	 * e.printStackTrace(); } finally { em.clear(); emf.close(); } }
	 */
}
