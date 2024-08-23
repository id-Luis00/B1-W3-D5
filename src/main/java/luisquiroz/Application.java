package luisquiroz;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import luisquiroz.DAO.LibroDAO;
import luisquiroz.DAO.RivistaDAO;
import luisquiroz.entities.Libro;
import luisquiroz.entities.Rivista;

import java.time.LocalDate;

public class Application {

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("B1-W3-D5");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        Libro primoLibro = new Libro("primo", "titolo", 200, LocalDate.of(2000, 3, 20), "me0", "horror");
        Rivista primaRivista = new Rivista("primaRivista", "prima rivista", 201230, LocalDate.of(1980, 2,20), Rivista.Periodicita.MENSILE);

        LibroDAO ld = new LibroDAO(em);
        RivistaDAO rd = new RivistaDAO(em);

        // salva un libro
        //ld.salva(primoLibro); // prova di salvataggio di un libro

        // salva una rivista
        //rd.salva(primaRivista);  // prova di salvataggio di una rivista


        System.out.println("Hello World!");


        em.close();
        emf.close();
    }
}
