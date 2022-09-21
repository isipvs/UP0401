package ru.mpt.p50_4_19.UP0401.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mpt.p50_4_19.UP0401.models.POrder;
@Repository
public interface OrderRepository extends JpaRepository<POrder, Integer> {
}