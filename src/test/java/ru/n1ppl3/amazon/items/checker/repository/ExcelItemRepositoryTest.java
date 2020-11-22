package ru.n1ppl3.amazon.items.checker.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;
import ru.n1ppl3.amazon.items.checker.entity.ExcelItem;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class ExcelItemRepositoryTest {

    @Autowired
    private ExcelItemRepository excelItemRepository;

    @Test
    @Transactional
    void repoTest() {
        ExcelItem excelItem = new ExcelItem();
        excelItem.setId(null);
        excelItem.setAmazonRegion("co.jp");
        excelItem.setAmazonItemId("B000059WOD");

        ExcelItem saved = excelItemRepository.save(excelItem);
        logger.warn("saved - {}", saved);
        assertTrue(saved.getId() > 0, () -> "id = " + saved.getId());
    }
}
