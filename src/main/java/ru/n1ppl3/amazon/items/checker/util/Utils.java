package ru.n1ppl3.amazon.items.checker.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.FileCopyUtils;
import ru.n1ppl3.amazon.items.checker.dto.SellingItem;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;

@Slf4j
public abstract class Utils {

    private static final String URL_TEMPLATE = "https://www.amazon.co.jp/gp/offer-listing/{0}/ref=dp_olp_new?ie=UTF8&condition=new";

    static String itemSellingPageUrl(String itemId) {
        return MessageFormat.format(URL_TEMPLATE, itemId);
    }

    public static SellingItem getAndParseSellingItemPage(String itemId) throws IOException {
        String url = itemSellingPageUrl(itemId);
        return getAndParseSellingItemPage(new URL(url));
    }

    public static SellingItem getAndParseSellingItemPage(URL url) throws IOException {
        String content = getContent(url);
        return parseContent(content);
    }

    private static String getContent(URL url) throws IOException {
        logger.info("gonna get {}", url);
        InputStream is = url.openStream();
        byte[] bytes = FileCopyUtils.copyToByteArray(is); // is closed
        return new String(bytes, StandardCharsets.UTF_8);
    }

    private static SellingItem parseContent(String content) {
        logger.info("gonna parse\n{}", content);
        return null; // TODO FIXME
    }

}
