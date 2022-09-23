package ru.mpt.p50_4_19.UP0401.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mpt.p50_4_19.UP0401.models.PItemRpr;

import java.util.List;

@Repository
public interface ItemRprRepository extends JpaRepository<PItemRpr, Integer> {

    List<PItemRpr> findByEmplIdOrderByDtEnd(int emplId );
}