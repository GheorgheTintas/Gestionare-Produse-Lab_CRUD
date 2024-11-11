package com.example.gestionareproduse.repository;

import com.example.gestionareproduse.model.Produs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdusRepository extends JpaRepository<Produs, Long> {
}