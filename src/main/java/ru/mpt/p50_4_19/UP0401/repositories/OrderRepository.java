package ru.mpt.p50_4_19.UP0401.repositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mpt.p50_4_19.UP0401.models.POrder;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<POrder, Integer> {

    List<POrder> findByEmplIdOrderByDtBeg( int emplId );
}