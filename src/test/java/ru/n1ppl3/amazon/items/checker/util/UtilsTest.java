package ru.n1ppl3.amazon.items.checker.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void itemSellingPageUrl() {
        assertEquals("https://www.amazon.co.jp/gp/offer-listing/B0006TPI66/ref=dp_olp_new?ie=UTF8&condition=new",
            Utils.itemSellingPageUrl("B0006TPI66"));
    }
}
