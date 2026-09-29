package br.com.etechoracio.academia.mapper;

import br.com.etechoracio.academia.dto.ExercicioFisicoRequestDTO;
import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDTO;
import br.com.etechoracio.academia.entity.ExercicioFisico;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = SalaMapper.class)
public interface SalaMapper {

    List<ExercicioFisicoResponseDTO> toRespostaDTOList(List<ExercicioFisico> entities);

    ExercicioFisicoResponseDTO toRespostaDTO(ExercicioFisico entity);

    ExercicioFisico toEntity(ExercicioFisicoRequestDTO dto);

    void updateEntityFromRequisicaoDTO(ExercicioFisicoRequestDTO dto, @MappingTarget ExercicioFisico entity);

}
