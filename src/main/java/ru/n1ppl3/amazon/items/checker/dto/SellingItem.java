package ru.n1ppl3.amazon.items.checker.dto;

import lombok.Data;

import java.util.List;

@Data
public class SellingItem {

    private String amazonItemId;
    private List<SellingOffer> offers;

    @Data
    public static class SellingOffer {
        private Integer price; // in yen
        private String sellerName;
    }
}
