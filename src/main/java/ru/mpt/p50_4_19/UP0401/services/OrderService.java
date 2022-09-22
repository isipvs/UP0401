package ru.mpt.p50_4_19.UP0401.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mpt.p50_4_19.UP0401.models.PCus;
import ru.mpt.p50_4_19.UP0401.models.PEmpl;
import ru.mpt.p50_4_19.UP0401.models.POrder;
import ru.mpt.p50_4_19.UP0401.repositories.CusRepository;
import ru.mpt.p50_4_19.UP0401.repositories.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;


@Service
@Transactional(readOnly = true)
public class OrderService {

    @Value("${app.title}")
    private String title;

    private PEmpl empl = new PEmpl();

    private final OrderRepository orderRepository;
    private final CusRepository cusRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, CusRepository cusRepository) {
        empl.setId(1);
        this.cusRepository = cusRepository;
        this.orderRepository = orderRepository;
    }

    private PEmpl getCurrentEmpl()
    {
        return empl;
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
    public void create( int cusId, String note ) {

        POrder newOrder = new POrder();
        newOrder.setCus  ( cusRepository.findById(cusId).get() );
        newOrder.setNote ( note);
        newOrder.setDtBeg( LocalDateTime.now() );
        newOrder.setStatus(1);

        save(newOrder);
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

    public List<PCus> getCusList() {
        return cusRepository.findAll();
    }
}
