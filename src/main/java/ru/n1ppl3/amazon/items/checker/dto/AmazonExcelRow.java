package ru.n1ppl3.amazon.items.checker.dto;

import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.Data;

/**
 * POJO для строки в excel файле
 */
@Data
@Immutable
public class AmazonExcelRow {

    private final String itemUrl;
}
