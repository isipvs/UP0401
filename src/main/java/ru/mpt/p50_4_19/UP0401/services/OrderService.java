package ru.mpt.p50_4_19.UP0401.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mpt.p50_4_19.UP0401.models.PEmpl;
import ru.mpt.p50_4_19.UP0401.models.POrder;
import ru.mpt.p50_4_19.UP0401.repositories.OrderRepository;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class OrderService {

    private PEmpl empl = new PEmpl();

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        empl.setId(-1);
        this.orderRepository = orderRepository;
    }

    private PEmpl getCurrentEmpl()
    {
        return null;
    }

    public List<POrder> findAll()
    {
        return orderRepository.findByEmplIdOrderByDtBeg( getCurrentEmpl().getId() );
    }

    public POrder findOne( int id ) {
        return orderRepository.getReferenceById(id);
    }

    @Transactional
    public void save( POrder order ) {

        // TODO:
        // Добавить ID текущего менеджера в ID_Empl в order
        order.setEmpl( getCurrentEmpl() );

        orderRepository.save(order);
    }

    @Transactional
    public void delete( int id ) {
        orderRepository.deleteById(id);
    }

    @Transactional
    public void updateNote( int id, String note )
    {
        POrder order = findOne(id);
        order.setNote(note);
        save(order);
    }
}
