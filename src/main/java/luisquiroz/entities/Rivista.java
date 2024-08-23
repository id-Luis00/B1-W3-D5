package luisquiroz.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "riviste")
public class Rivista extends ElementoCatalogo {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Periodicita periodicita;

    // Costruttori, getter, setter, etc.

    public enum Periodicita {
        SETTIMANALE, MENSILE, SEMESTRALE
    }

    public Rivista() {
    }

    public Rivista(String isbn, String titolo, int numeroPagine, LocalDate annoPubblicazione, Periodicita periodicita) {
        super(isbn, titolo, numeroPagine, annoPubblicazione);
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicita=" + periodicita +
                '}';
    }
}
