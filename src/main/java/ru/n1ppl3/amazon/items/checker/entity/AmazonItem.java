package ru.n1ppl3.amazon.items.checker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "amazon_items")
public class AmazonItem {

    @Id
    @Column(name = "amazon_item_id", nullable = false, unique = true, length = 10)
    private String amazonItemId; // B000059WOD

    @Column(name = "description", nullable = false, unique = true, length = 128)
    private String description; // Linking Park - Hybrid Theory

    @Column(name = "catalogue_number", nullable = false, unique = true, length = 10)
    private String catalogueNumber; // WPCR-10877

    @Column(name = "release_date")
    private LocalDate releaseDate; // 2001-02-07

}
