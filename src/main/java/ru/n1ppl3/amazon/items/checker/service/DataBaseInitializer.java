package ru.n1ppl3.amazon.items.checker.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.n1ppl3.amazon.items.checker.dto.AmazonExcelRow;
import ru.n1ppl3.amazon.items.checker.dto.AmazonUrl;
import ru.n1ppl3.amazon.items.checker.entity.ExcelItem;
import ru.n1ppl3.amazon.items.checker.repository.ExcelItemRepository;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static ru.n1ppl3.amazon.items.checker.util.MyCollectionUtils.transformToList;
import static ru.n1ppl3.amazon.items.checker.util.MyCollectionUtils.transformToSet;

@Slf4j
@Service
@AllArgsConstructor
public class DataBaseInitializer {

    private final ExcelItemRepository excelItemRepository;

    @Transactional
    public void parseAndSave(Resource resource) throws IOException {
        // находим в файле ссылки на амазоновские item'ы
        List<AmazonExcelRow> rows = AmazonExcelParser.parseExcelFile(resource);
        logger.info("Found {} URLs", rows.size());

        // валидируем их и удаляем дубли за счёт использования Set
        Set<AmazonUrl> amazonUrls = transformToSet(rows, row -> new AmazonUrl(row.getItemUrl()));
        logger.info("Parsed {} URLs", amazonUrls.size());

        // превращаем их в сущности БД и сохраняем
        List<ExcelItem> excelItems = transformToList(amazonUrls, amazonUrl -> new ExcelItem(amazonUrl.getRegion().getCode(), amazonUrl.getAmazonItemId()));
        List<ExcelItem> saved = excelItemRepository.saveAll(excelItems);
        logger.info("Saved {} URLs", saved.size());
    }

}
