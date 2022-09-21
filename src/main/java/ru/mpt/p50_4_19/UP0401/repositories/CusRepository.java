package ru.mpt.p50_4_19.UP0401.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mpt.p50_4_19.UP0401.models.PCus;
import ru.mpt.p50_4_19.UP0401.models.PDol;

@Repository
public interface CusRepository extends JpaRepository<PCus, Integer> {
}