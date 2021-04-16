package br.com.bandtec.lutamilene.controller;


import br.com.bandtec.lutamilene.Response.LutadorResponse;
import br.com.bandtec.lutamilene.dominio.Lutadores;
import br.com.bandtec.lutamilene.repository.LutadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/lutadores")
public class LutadorController {

    @Autowired
    private LutadorRepository repository;

    @PostMapping
    public ResponseEntity postLutador(@RequestBody @Valid Lutadores lutador) {
        repository.save(lutador);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getLutadores() {
        List<Lutadores> lutadores = repository.findAllByOrdergolpeForcaDesc();

        if (!lutadores.isEmpty()) {
            return ResponseEntity.ok(lutadores);

        }
        else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/contagem-vivos")
    public ResponseEntity getLutadoresVivos(){
        return ResponseEntity.ok().body(repository.countByVivo(true));
    }

    @PostMapping("/{id}/concentrar")
    public  ResponseEntity postConcentrar(@PathVariable Integer id){
        Lutadores lutador = repository.getOne(id);
        if (lutador.getConcentracoesRealizadas() <=3){
            lutador.setConcentracoesRealizadas();
        }
            return ResponseEntity.status(400).build();


    }
}
