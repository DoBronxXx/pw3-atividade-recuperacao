package br.com.etechoracio.academia.service;

import br.com.etechoracio.academia.dto.ExercicioFisicoRequestDTO;
import br.com.etechoracio.academia.dto.ExercicioFisicoResponseDTO;
import br.com.etechoracio.academia.mapper.SalaMapper;
import br.com.etechoracio.academia.repository.ExercicioFisicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ExercicioFisicoService {

    @Autowired
    private ExercicioFisicoRepository salaRepository;

    @Autowired
    private SalaMapper salaMapper;

    public List<ExercicioFisicoResponseDTO> findAtivas() {
        var result = salaRepository.findByDataExclusaoIsNull();
        return salaMapper.toRespostaDTOList(result);
    }

    public Optional<ExercicioFisicoResponseDTO> findById(Long id) {
        return salaRepository.findByIdAndDataExclusaoIsNull(id)
                .map(salaMapper::toRespostaDTO);
    }

    public ExercicioFisicoResponseDTO create(ExercicioFisicoRequestDTO salaRequestDTO) {
        var sala = salaMapper.toEntity(salaRequestDTO);
        var salaSalva = salaRepository.save(sala);
        return salaMapper.toRespostaDTO(salaSalva);
    }

    public boolean delete(Long id) {
        return salaRepository.findById(id).map(e -> {
            e.setDataExclusao(LocalDateTime.now());
            salaRepository.save(e);
            return true;
        }).orElse(false);
    }

    public Optional<ExercicioFisicoResponseDTO> update(Long id, ExercicioFisicoRequestDTO salaRequestDTO) {
        return salaRepository.findById(id)
                .map(e -> {
                    salaMapper.updateEntityFromRequisicaoDTO(salaRequestDTO, e);
                    var salaAtualizada = salaRepository.save(e);
                    return salaMapper.toRespostaDTO(salaAtualizada);
                });
    }


}
