package br.com.etechoracio.academia.service;

import br.com.etechoracio.academia.dto.ExercicioDTO;
import br.com.etechoracio.academia.mapper.ExercicioMapper;
import br.com.etechoracio.academia.repository.ExercicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercicioService {

    private final ExercicioRepository repository;
    private final ExercicioMapper mapper;

    public ExercicioService(
            ExercicioRepository repository,
            ExercicioMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ExercicioDTO> listarAprovados() {

        return repository.findByAprovadoTrue()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}