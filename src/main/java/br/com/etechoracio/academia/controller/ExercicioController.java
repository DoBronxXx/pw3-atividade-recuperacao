package br.com.etechoracio.academia.controller;

import br.com.etechoracio.academia.dto.ExercicioDTO;
import br.com.etechoracio.academia.service.ExercicioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exercicios-fisicos")
public class ExercicioController {

    private final ExercicioService service;

    public ExercicioController(ExercicioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ExercicioDTO>> listar() {

        return ResponseEntity.ok(service.listarAprovados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExercicioDTO> buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}