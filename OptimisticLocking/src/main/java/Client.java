import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.learn.dao.Movie;
//--add-opens java.base/java.lang=ALL-UNNAMED <<Add in VM Argument>>
public class Client {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		Session s = config.buildSessionFactory().openSession();
		Movie m1 = new Movie();
		m1.setMovieName("Titanic");
		m1.setActor("Leonardo di caprio");
		
		Movie m2 = new Movie();
		m2.setMovieName("Mission Impossible");
		m2.setActor("Tom Cruise");
		
		s.getTransaction().begin();
		
		s.save(m1);
		s.save(m2);
		
		s.getTransaction().commit();
		
		int mid =2;
		Movie m = s.get(Movie.class,mid);
		if(m!=null) {
			s.getTransaction().begin();
			m.setActor("kate winslet");
			s.update(m);
			s.getTransaction().commit();
		} else {
			System.out.println("Movie details not found!");
		}
		
		s.close();
		
		
		
	}
}
