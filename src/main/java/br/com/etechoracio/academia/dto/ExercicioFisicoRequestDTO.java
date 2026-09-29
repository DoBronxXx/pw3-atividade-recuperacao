package br.com.etechoracio.academia.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados para criar ou atualizar uma sala")
public record ExercicioFisicoRequestDTO(
        @Schema(description = "Nome da sala", example = "Sala 1") String nome,
        @Schema(description = "Preço base do ingresso na sala", example = "32.50") Double preco
) {
}

