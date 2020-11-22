package ru.n1ppl3.amazon.items.checker.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name = "excel_items")
public class ExcelItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "amazon_region", nullable = false, length = 5)
    private String amazonRegion; // co.jp

    @Column(name = "amazon_item_id", nullable = false, length = 10)
    private String amazonItemId; // B000059WOD

    public ExcelItem(String amazonRegion, String amazonItemId) {
        this.amazonRegion = amazonRegion;
        this.amazonItemId = amazonItemId;
    }

}
