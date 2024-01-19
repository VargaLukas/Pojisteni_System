package net.javaproject.lukas.service.impl;

import net.javaproject.lukas.entity.Pojisteni;
import net.javaproject.lukas.repository.PojisteniRepository;
import net.javaproject.lukas.service.PojisteniService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PojisteniServiceImpl implements PojisteniService {

    private PojisteniRepository pojisteniRepository;

    public PojisteniServiceImpl(PojisteniRepository pojisteniRepository) {
        super();
        this.pojisteniRepository = pojisteniRepository;
    }

    @Override
    public List<Pojisteni> getAllPojisteni() {return pojisteniRepository.findAll();}

    @Override
    public Pojisteni savePojisteni(Pojisteni pojisteni) {return pojisteniRepository.save(pojisteni);}

    @Override
    public Pojisteni getPojisteniById(Long id) {return pojisteniRepository.findById(id).get();}

    @Override
    public Pojisteni updatePojisteni(Pojisteni pojisteni) {return pojisteniRepository.save(pojisteni);}

    @Override
    public void deletePojisteniById(Long id) {pojisteniRepository.deleteById(id);}

}
