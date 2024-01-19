package net.javaproject.lukas.repository;

import net.javaproject.lukas.entity.Uzivatel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UzivatelRepository extends JpaRepository<Uzivatel, Long> {

}
