package ru.n1ppl3.amazon.items.checker.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AmazonUrlTest {

    @Test
    void test() {
        AmazonUrl amazonUrl = new AmazonUrl("http://www.amazon.co.jp/gp/offer-listing/B000AA7D8M/ref=dp_olp_new?ie=UTF8&condition=new");
        assertEquals(AmazonRegion.JAPAN, amazonUrl.getRegion());
        assertEquals("B000AA7D8M", amazonUrl.getAmazonItemId());
    }
}
