package net.javaproject.lukas.service.impl;

import net.javaproject.lukas.entity.Uzivatel;
import net.javaproject.lukas.repository.UzivatelRepository;
import net.javaproject.lukas.service.UzivatelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UzivatelServiceImpl implements UzivatelService {

    private UzivatelRepository uzivatelRepository;

   public UzivatelServiceImpl(UzivatelRepository uzivatelRepository) {
       super();
       this.uzivatelRepository = uzivatelRepository;
   }

   @Override
   public List<Uzivatel> getAllUzivatele() {return uzivatelRepository.findAll();}

   @Override
   public Uzivatel saveUzivatel(Uzivatel uzivatel) {return uzivatelRepository.save(uzivatel);}

   @Override
   public Uzivatel getUzivatelById(Long id) {return uzivatelRepository.findById(id).orElse(null);} // zmena z get na orElse(null)

   @Override
   public Uzivatel updateUzivatel(Uzivatel uzivatel) {return uzivatelRepository.save(uzivatel);}

   @Override
   public void deleteUzivatelById(Long id) {uzivatelRepository.deleteById(id);}

}
