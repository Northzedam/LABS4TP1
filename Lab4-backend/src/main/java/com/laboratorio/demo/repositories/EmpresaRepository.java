package com.laboratorio.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.laboratorio.demo.entities.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

}
