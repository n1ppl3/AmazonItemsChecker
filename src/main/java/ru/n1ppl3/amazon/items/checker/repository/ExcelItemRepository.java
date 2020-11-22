package ru.n1ppl3.amazon.items.checker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.n1ppl3.amazon.items.checker.entity.ExcelItem;

@Repository
public interface ExcelItemRepository extends JpaRepository<ExcelItem, String> {

}
