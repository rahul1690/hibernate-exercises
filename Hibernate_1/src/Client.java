import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learn.config.HibernateUtil;
import com.learn.dao.Student;
//--add-opens java.base/java.lang=ALL-UNNAMED Add in VM Argument

public class Client {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Student student = new Student();
			student.setId(102);
			student.setName("Rama");		
			
			session.save(student);
			
			Student s1 = (Student) session.load(Student.class, student.getId());
			System.out.println(s1.getName());
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
