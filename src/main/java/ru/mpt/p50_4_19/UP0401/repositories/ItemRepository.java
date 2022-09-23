package ru.mpt.p50_4_19.UP0401.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.mpt.p50_4_19.UP0401.models.PItem;
import ru.mpt.p50_4_19.UP0401.models.PItemRpr;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<PItem, Integer> {
    @Modifying
    @Query("update PItem  set dtEnd = :dtend where id = :id")
    int makeCompleted(@Param("dtend") LocalDateTime status, @Param("id") Integer id);

    @Modifying
    @Query("update PItem set dtBeg = :dtbeg where id = :id")
    int takeToWork(@Param("dtbeg") LocalDateTime status, @Param("id") Integer id);

}