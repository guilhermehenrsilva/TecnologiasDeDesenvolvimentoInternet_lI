package br.edu.ifsuldeminas.mch.webii.crudmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Farmacia;

@Repository
public interface FarmaciaRepository extends JpaRepository<Farmacia, Integer>{
    
}
