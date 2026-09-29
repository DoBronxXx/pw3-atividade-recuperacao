package br.com.etechoracio.academia.controller;

import br.com.etechoracio.academia.dto.ExercicioFisicoRequestDTO;
import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDTO;
import br.com.etechoracio.academia.service.ExercicioFisicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
@CrossOrigin("*")
@Tag(name = "Salas", description = "Cadastro e consulta de salas de cinema")
public class ExercicioFisicoController {

    @Autowired
    private ExercicioFisicoService salaService;

    @GetMapping
    @Operation(summary = "Lista salas ativas")
    @ApiResponse(responseCode = "200", description = "Lista de salas ativas")
    public List<ExercicioFisicoResponseDTO> findAtivos() {
        return salaService.findAtivas();
    }

    @PostMapping
    @Operation(summary = "Cria uma sala")
    @ApiResponse(responseCode = "201", description = "Sala criada")
    public ResponseEntity<ExercicioFisicoResponseDTO> create(@RequestBody ExercicioFisicoRequestDTO dto) {
        ExercicioFisicoResponseDTO salaCriada = salaService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salaCriada);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca sala pelo identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Sala encontrada"),
            @ApiResponse(responseCode = "404", description = "Sala não encontrada")
    })
    public ResponseEntity<ExercicioFisicoResponseDTO> findById(
            @Parameter(description = "Identificador da sala", required = true) @PathVariable Long id) {
        return salaService.findById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Inativa uma sala")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Sala inativada"),
            @ApiResponse(responseCode = "404", description = "Sala não encontrada")
    })
    public ResponseEntity<Void> delete(
            @Parameter(description = "Identificador da sala", required = true) @PathVariable Long id) {
        if (salaService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma sala")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Sala atualizada"),
            @ApiResponse(responseCode = "404", description = "Sala não encontrada")
    })
    public ResponseEntity<ExercicioFisicoResponseDTO> update(
            @Parameter(description = "Identificador da sala", required = true) @PathVariable Long id,
            @RequestBody ExercicioFisicoRequestDTO dto) {
        return salaService.update(id, dto).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
