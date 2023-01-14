package ru.ssau.esa_lab24.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ssau.esa_lab24.models.Item;
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
