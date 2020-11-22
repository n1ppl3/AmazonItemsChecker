package ru.n1ppl3.amazon.items.checker.dto;

import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * регион амазоновского сайта
 * co.jp, com и т.д.
 */
@Immutable
@AllArgsConstructor
public enum AmazonRegion {

    GERMANY("de"),
    JAPAN("co.jp"),
    USA("com"),
    UK("co.uk");

    @Getter
    private final String code;

    public static AmazonRegion fromString(String str) {
        for (AmazonRegion amazonRegion : AmazonRegion.values()) {
            if (amazonRegion.code.equalsIgnoreCase(str)) {
                return amazonRegion;
            }
        }
        throw new IllegalArgumentException("Unsupported AmazonRegion - " + str);
    }
}
