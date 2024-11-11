package com.example.gestionareproduse.service;



import com.example.gestionareproduse.model.Produs;
import com.example.gestionareproduse.repository.ProdusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdusService {

    @Autowired
    private ProdusRepository produsRepository;

    // Creare produs
    public Produs addProdus(Produs produs) {
        return produsRepository.save(produs);
    }

    // Citire produse
    public List<Produs> getAllProduse() {
        return produsRepository.findAll();
    }

    // Citire produs după ID
    public Optional<Produs> getProdusById(Long id) {
        return produsRepository.findById(id);
    }

    // Actualizare produs
    public Produs updateProdus(Long id, Produs produsDetalii) {
        if (produsRepository.existsById(id)) {
            produsDetalii.setId(id);
            return produsRepository.save(produsDetalii);
        }
        return null; // Sau poți arunca o excepție
    }

    // Ștergere produs
    public boolean deleteProdus(Long id) {
        if (produsRepository.existsById(id)) {
            produsRepository.deleteById(id);
            return true;
        }
        return false; // Sau poți arunca o excepție
    }
}
