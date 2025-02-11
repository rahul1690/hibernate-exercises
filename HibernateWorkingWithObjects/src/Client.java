import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learn.config.HibernateUtil;
import com.learn.dao.Student;
//--add-opens java.base/java.lang=ALL-UNNAMED <<Add in VM Argument>>
public class Client {
	
	public void addStudent(Student s,Session session) {
		session.save(s);
	}
	public void updateStudent(int studentId,String studentName,Session session) {
		Student s = (Student) session.load(Student.class,studentId);
		s.setId(studentId);
		s.setName(studentName);
		session.update(s);
	}
	
	public void deleteStudent(int studentId, Session session) {
		Student s = (Student) session.load(Student.class, studentId);
		session.delete(s);
	}
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Student s1 = new Student(1, "Peter");
		Student s2 = new Student(2, "Sam");
		
		try {
			Client c = new Client();
//			c.addStudent(s1, session);
//			c.addStudent(s2, session);
			
//			c.updateStudent(2, "Gabriel", session);
			c.deleteStudent(2, session);
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
		
		tx.commit();
		session.close();
		
	}

}
