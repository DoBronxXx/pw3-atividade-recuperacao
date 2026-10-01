package br.com.etechoracio.academia.service;

import br.com.etechoracio.academia.dto.ExercicioDTO;
import br.com.etechoracio.academia.dto.ExercicioRequest;
import br.com.etechoracio.academia.entity.ExercicioFisico;
import br.com.etechoracio.academia.mapper.ExercicioMapper;
import br.com.etechoracio.academia.repository.ExercicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<ExercicioDTO> buscarPorId(Long id){
        return repository.findByIdAndAprovadoTRUE(id).map(mapper::toResponse);
    }

    public ExercicioDTO cadastrar(ExercicioRequest request){
        ExercicioFisico exer = mapper.toEntity(request);
        exer.setAprovado(false);
        ExercicioFisico salvo = repository.save(exer);

        return mapper.toResponse(salvo);
    }

    public Optional<ExercicioDTO> aprovar(Long id){
        return repository.findById(id).map(exercicio -> {
            exercicio.setAprovado(true);
            ExercicioFisico salvo = repository.save(exercicio);

            return mapper.toResponse(salvo);
        });
    }
}