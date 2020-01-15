package ru.n1ppl3.amazon.items.checker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.n1ppl3.amazon.items.checker.entity.AmazonItem;

@Repository
public interface AmazonItemRepository extends JpaRepository<AmazonItem, String> {

}
