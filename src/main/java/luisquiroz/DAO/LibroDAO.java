package luisquiroz.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import luisquiroz.entities.Libro;

import java.util.List;

public class LibroDAO {

    private final EntityManager entityManager;

    public LibroDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salva(Libro libro) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(libro);
            transaction.commit();
            System.out.println("salvataggio effettuato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
