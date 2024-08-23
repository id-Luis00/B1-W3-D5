package luisquiroz.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "elementi_catalogo")
public abstract class ElementoCatalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String titolo;

    @Column(name = "anno_pubblicazione", nullable = false)
    private LocalDate annoPubblicazione;

    @Column(name = "numero_pagine", nullable = false)
    private int numeroPagine;

    // Costruttori, getter, setter, etc.


    public ElementoCatalogo() {
    }

    public ElementoCatalogo(String isbn, String titolo, int numeroPagine, LocalDate annoPubblicazione) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.numeroPagine = numeroPagine;
        this.annoPubblicazione = annoPubblicazione;
    }

    @Override
    public String toString() {
        return "ElementoCatalogo{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
