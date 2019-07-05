import flights.Airline;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App {
	private static Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String argv[]){
		System.out.println("Running App ...");

		log.debug("Create persistence manager");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
		EntityManager em = emf.createEntityManager();

		log.debug("Search for french Airlines");
		List<Airline> airlines = em.createQuery("from Airline as al where al.country = :country", Airline.class)
				.setParameter("country", "France")
				.getResultList();


		showAirlines(airlines);

		log.debug("Search for french Airlines going to Miami");
		airlines = em.createQuery(" select rt.airline from Route as rt join rt.airline as al"
				+ " join rt.destination as dst"
		+ " where al.country = :country and dst.city = :city", Airline.class)
				.setParameter("country", "France")
				.setParameter("city", "Miami")
				.getResultList();

		showAirlines(airlines);
	}

	private static void showAirlines(List<Airline> airlines) {

		System.out.println(
				String.format("%5s | %3s | %-30s ",
						"Id",
						"ICAO",
						"Name"
				)
		);
		for (Airline airline : airlines) {
			System.out.println(
					String.format("%5s | %3s | %-30s ",
							airline.getId(),
							airline.getIcao(),
							airline.getName()
					)
			);
		}
	}
}
