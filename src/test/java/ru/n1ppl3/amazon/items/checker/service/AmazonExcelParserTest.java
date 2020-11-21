package ru.n1ppl3.amazon.items.checker.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import ru.n1ppl3.amazon.items.checker.dto.AmazonExcelRow;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AmazonExcelParserTest {

    @Test
    void parseExcelFileTest() throws IOException {
        List<AmazonExcelRow> rows = AmazonExcelParser.parseExcelFile(new ClassPathResource("amazon-items-example.xlsx"));
        assertEquals(2, rows.size());
        Assertions.assertThat(rows.get(0).getItemUrl()).contains("B000TLYFPG");
        Assertions.assertThat(rows.get(1).getItemUrl()).contains("B0071NB3RI");
    }
}
