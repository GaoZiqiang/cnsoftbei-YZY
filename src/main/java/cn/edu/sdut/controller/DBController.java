package cn.edu.sdut.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;//注意是这个
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cn.edu.sdut.model.Category;
import cn.edu.sdut.model.Stuff;

@RequestScoped
@ManagedBean(name = "controller")
public class DBController {

	private Stuff newStuff;
	private Category newCategory;
	public Stuff getNewStuff() {
		return newStuff;
	}

	public void setNewStuff(Stuff newStuff) {
		this.newStuff = newStuff;
	}

	

	public Category getNewCategory() {
		return newCategory;
	}

	public void setNewCategory(Category newCategory) {
		this.newCategory = newCategory;
	}

	public void connectDB() {
		System.out.println("start!");
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("YZYWeixin");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			System.out.println("打印输emf: " + emf.toString());
			System.out.println("打印输em: " + em.toString());
			System.out.println("打印输出newCategory: " + newCategory.toString());
			// newStuff.setName("gaoziqiang");
			//newCategory.setName("gaoziqiang");
			//newCategory.setBarcode("gaoziqiang");
			// System.out.println("打印输出newStuff:" + newStuff.toString() +
			// "以及newStuff的name属性: " + newStuff.getName());
			//em.persist(newCategory);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}

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
