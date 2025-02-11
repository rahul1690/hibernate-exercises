import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learn.config.HibernateUtil;
import com.learn.dao.Album;
//--add-opens java.base/java.lang=ALL-UNNAMED
public class Client {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Album album = new Album("Bali trip 2018");
		Set<String> pics = new HashSet<>();
		pics.add("sunset");
		pics.add("Borong dance");
		pics.add("Borong dance");
		album.setPictures(pics);
		try {
			session.save(album);
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		
		tx.commit();
		session.close();
	}
}
