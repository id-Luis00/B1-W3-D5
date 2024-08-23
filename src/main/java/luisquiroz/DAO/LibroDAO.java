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

    public Libro cercaPerISBN(String isbn) {
        return entityManager.find(Libro.class, isbn);
    }

    public void elimina(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Libro libro = entityManager.find(Libro.class, id);
            if (libro != null) {
                entityManager.remove(libro);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public List<Libro> cercaTutti() {
        TypedQuery<Libro> query = entityManager.createQuery("SELECT l FROM Libro l", Libro.class);
        return query.getResultList();
    }
}
