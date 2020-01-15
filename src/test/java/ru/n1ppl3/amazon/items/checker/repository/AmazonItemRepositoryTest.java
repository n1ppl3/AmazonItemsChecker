package ru.n1ppl3.amazon.items.checker.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;
import ru.n1ppl3.amazon.items.checker.entity.AmazonItem;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class AmazonItemRepositoryTest {

    @Autowired
    private AmazonItemRepository amazonItemRepository;

    @Test
    @Transactional
    void repoTest() {
        AmazonItem amazonItem = new AmazonItem();
        amazonItem.setId(null);
        amazonItem.setAmazonItemId("B000059WOD");
        amazonItem.setDescription("Linking Park - Hybrid Theory");
        amazonItem.setCatalogueNumber("WPCR-10877");
        amazonItem.setReleaseDate(LocalDate.of(2001,2,7));

        AmazonItem saved = amazonItemRepository.save(amazonItem);
        logger.warn("saved - {}", saved);
        assertTrue(saved.getId() > 0, () -> "id = " + saved.getId());
        assertEquals(Boolean.TRUE, saved.getIsActive());
    }

}
