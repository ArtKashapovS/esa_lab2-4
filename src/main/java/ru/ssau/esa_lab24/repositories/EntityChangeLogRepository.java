package ru.ssau.esa_lab24.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ssau.esa_lab24.models.EntityChangeLog;

@Repository
public interface EntityChangeLogRepository extends JpaRepository<EntityChangeLog, Integer> {
}
