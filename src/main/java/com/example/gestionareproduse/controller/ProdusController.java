package com.example.gestionareproduse.controller;


import com.example.gestionareproduse.model.Produs;
import com.example.gestionareproduse.service.ProdusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produse")
public class ProdusController {

    @Autowired
    private ProdusService produsService;

    // Creare produs
    @PostMapping
    public ResponseEntity<Produs> addProdus(@RequestBody Produs produs) {
        Produs produsCreare = produsService.addProdus(produs);
        return new ResponseEntity<>(produsCreare, HttpStatus.CREATED);
    }

    // Citire toate produsele
    @GetMapping
    public ResponseEntity<List<Produs>> getAllProduse() {
        List<Produs> produse = produsService.getAllProduse();
        return new ResponseEntity<>(produse, HttpStatus.OK);
    }

    // Citire produs după ID
    @GetMapping("/{id}")
    public ResponseEntity<Produs> getProdusById(@PathVariable Long id) {
        Optional<Produs> produs = produsService.getProdusById(id);
        return produs.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizare produs
    @PutMapping("/{id}")
    public ResponseEntity<Produs> updateProdus(@PathVariable Long id, @RequestBody Produs produsDetalii) {
        Produs produsActualizat = produsService.updateProdus(id, produsDetalii);
        return produsActualizat != null
                ? new ResponseEntity<>(produsActualizat, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Ștergere produs
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProdus(@PathVariable Long id) {
        return produsService.deleteProdus(id)
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

