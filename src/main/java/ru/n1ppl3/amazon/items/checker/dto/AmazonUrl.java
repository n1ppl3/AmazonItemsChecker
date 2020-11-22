package ru.n1ppl3.amazon.items.checker.dto;

import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.Data;

/**
 * parser for URLs just like this
 * http://www.amazon.co.jp/gp/offer-listing/B000AA7D8M/ref=dp_olp_new?ie=UTF8&condition=new
 */
@Data
@Immutable
public class AmazonUrl {

    private static final String AMAZON = "amazon.";
    private static final String OFFER_LISTING = "offer-listing/";

    private final AmazonRegion region;
    private final String amazonItemId;

    public AmazonUrl(String url) {
        if (url == null || !url.contains(AMAZON) || !url.contains(OFFER_LISTING)) {
            throw new IllegalArgumentException("Bad amazon url: " + url);
        }
        this.region = AmazonRegion.fromString(cutBetweenStrings(url, AMAZON, "/"));
        this.amazonItemId = cutBetweenStrings(url, OFFER_LISTING, "/");
    }

    private static String cutBetweenStrings(String str, String startSequence, String endSequence) {
        int start = str.indexOf(startSequence) + startSequence.length();
        String newSearchString = str.substring(start);
        return newSearchString.substring(0, newSearchString.indexOf(endSequence));
    }
}
