package ru.mpt.p50_4_19.UP0401.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mpt.p50_4_19.UP0401.models.PItemRpr;
import ru.mpt.p50_4_19.UP0401.repositories.ItemRprRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRprRepository itemRprRepository;

    @Autowired
    public ItemService(ItemRprRepository itemRprRepository) {
        this.itemRprRepository = itemRprRepository;
    }

    /** */
    public List<PItemRpr> findRprAll( )
    {
        return itemRprRepository.findByEmplId(4);
    }
}
