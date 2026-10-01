package br.com.etechoracio.academia.mapper;

import br.com.etechoracio.academia.dto.ExercicioDTO;
import br.com.etechoracio.academia.entity.ExercicioFisico;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExercicioMapper {

    ExercicioDTO toResponse(ExercicioFisico exercicio);

}