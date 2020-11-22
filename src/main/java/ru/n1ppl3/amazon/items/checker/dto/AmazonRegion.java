package ru.n1ppl3.amazon.items.checker.dto;

public enum AmazonRegion {

    GERMANY("de"),
    JAPAN("co.jp"),
    USA("com"),
    UK("co.uk");

    private final String code;

    AmazonRegion(String code) {
        this.code = code;
    }

    public static AmazonRegion fromString(String str) {
        for (AmazonRegion amazonRegion : AmazonRegion.values()) {
            if (amazonRegion.code.equalsIgnoreCase(str)) {
                return amazonRegion;
            }
        }
        throw new IllegalArgumentException("Unsupported AmazonRegion - " + str);
    }
}
