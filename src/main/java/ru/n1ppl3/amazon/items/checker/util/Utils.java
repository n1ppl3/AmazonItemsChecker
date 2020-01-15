package ru.n1ppl3.amazon.items.checker.util;

import java.text.MessageFormat;


public abstract class Utils {

    private static final String URL_TEMPLATE = "https://www.amazon.co.jp/gp/offer-listing/{0}/ref=dp_olp_new?ie=UTF8&condition=new";


    public static String itemSellingPageUrl(String itemId) {
        return MessageFormat.format(URL_TEMPLATE, itemId);
    }

}
