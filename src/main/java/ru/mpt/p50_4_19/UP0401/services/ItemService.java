package ru.mpt.p50_4_19.UP0401.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mpt.p50_4_19.UP0401.models.PItemRpr;
import ru.mpt.p50_4_19.UP0401.repositories.ItemRepository;
import ru.mpt.p50_4_19.UP0401.repositories.ItemRprRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRprRepository itemRprRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRprRepository itemRprRepository, ItemRepository itemRepository) {
        this.itemRprRepository = itemRprRepository;
        this.itemRepository = itemRepository;
    }

    /** */
    public List<PItemRpr> findRprAll( )
    {
        return itemRprRepository.findByEmplIdOrderByDtEnd(2);
    }

    // Делает работу по предмету завершенным
    // вызваемся из АРМ мастера
    @Transactional
    public void makeComplete( Integer itemId )
    {
        itemRepository.makeCompleted( LocalDateTime.now(), itemId );
    }

    // начинает работу по предмету
    // вызваемся из АРМ мастера
    @Transactional
    public void takeToWork( Integer itemId )
    {
        itemRepository.takeToWork( LocalDateTime.now(), itemId );
    }

}
