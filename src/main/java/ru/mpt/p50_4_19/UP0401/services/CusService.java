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
public class CusService {

    private final CusRepository cusRepository;

    @Autowired
    public CusService(CusRepository cusRepository) {
        this.cusRepository = cusRepository;
    }

    public List<PCus> findAll()
    {
        return cusRepository.findAll();
    }

    @Transactional
    public void save( PCus cus )
    {
    // TODO:
        // Добавить ID текущего менеджера в ID_Empl в order
        cusRepository.save(cus);
    }

    @Transactional
    public void create( String name, String email, String phone )
    {
        PCus newCus = new PCus(name,email,phone);
        // TODO:
        // Добавить ID текущего менеджера в ID_Empl в order
        cusRepository.save(newCus);
    }


    @Transactional
    public void delete( int id ) {
        cusRepository.deleteById(id);
    }
}
