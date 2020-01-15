package ru.n1ppl3.amazon.items.checker.util;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import ru.n1ppl3.amazon.items.checker.dto.SellingItem;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


class UtilsTest {

    @Test
    void itemSellingPageUrl() {
        assertEquals("https://www.amazon.co.jp/gp/offer-listing/B0006TPI66/ref=dp_olp_new?ie=UTF8&condition=new",
            Utils.itemSellingPageUrl("B0006TPI66"));
    }

    @Test
    void getAndParseSellingItemPageReal() throws IOException {
        SellingItem sellingItem = Utils.getAndParseSellingItemPage("B0006TPI66");
        assertEquals(null, sellingItem);
    }

    @Test
    void getAndParseSellingItemPageFromFileSystem() throws IOException {
        Resource resource = new ClassPathResource("test-page.html");
        SellingItem sellingItem = Utils.getAndParseSellingItemPage(resource.getURL());
        assertEquals(null, sellingItem);
    }
}
