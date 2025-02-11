import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learn.config.HibernateUtil;
import com.learn.dao.Student;

public class Client {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Student student = new Student();
			student.setId(101);
			student.setName("Ram");		
			
			session.save(student);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
