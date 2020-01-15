package ru.n1ppl3.amazon.items.checker.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "amazon_items")
public class AmazonItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "amazon_item_id", nullable = false, unique = true, length = 10)
    private String amazonItemId; // B000059WOD

    @Column(name = "description", nullable = false, length = 128)
    private String description; // Linking Park - Hybrid Theory

    @Column(name = "catalogue_number", nullable = false, unique = true, length = 10)
    private String catalogueNumber; // WPCR-10877

    @Column(name = "release_date")
    private LocalDate releaseDate; // 2001-02-07

    @Column(name = "is_active")
    private Boolean isActive = true; // продолжаем ли мы наблюдать за этим item'ом

    @Column(name = "last_check")
    private LocalDateTime lastCheck; // time of last check, in UTC

}
