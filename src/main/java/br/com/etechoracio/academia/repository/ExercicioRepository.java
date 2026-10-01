package br.com.etechoracio.academia.repository;

import br.com.etechoracio.academia.entity.ExercicioFisico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExercicioRepository extends JpaRepository<ExercicioFisico, Long> {

    List<ExercicioFisico> findByAprovadoTrue();


    Optional<ExercicioFisico> findByIdAndAprovadoTRUE(Long id);
}