package luisquiroz.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import luisquiroz.entities.Rivista;

import java.util.List;

public class RivistaDAO {

    private EntityManager entityManager;

    public RivistaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salva(Rivista rivista) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(rivista);
            transaction.commit();
            System.out.println("salvato con successo:" + rivista.getTitolo());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
