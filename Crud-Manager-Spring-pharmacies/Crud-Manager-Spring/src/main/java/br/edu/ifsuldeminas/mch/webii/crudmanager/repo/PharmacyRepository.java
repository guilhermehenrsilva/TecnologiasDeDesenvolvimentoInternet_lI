package br.edu.ifsuldeminas.mch.webii.crudmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Pharmacy;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Integer>{

}
