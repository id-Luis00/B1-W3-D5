package luisquiroz;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import luisquiroz.DAO.LibroDAO;
import luisquiroz.entities.Libro;

import java.time.LocalDate;

public class Application {

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("B1-W3-D5");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        Libro primoLibro = new Libro( "primo","titolo", 200, LocalDate.of(2000, 3,20), "me0", "horror");

        LibroDAO ld = new LibroDAO(em);


       ld.salva(primoLibro);
       ld.cercaPerISBN("primo");





        System.out.println("Hello World!");
    }
}
