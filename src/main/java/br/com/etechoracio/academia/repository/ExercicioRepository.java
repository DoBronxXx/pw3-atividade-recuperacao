package br.com.etechoracio.academia.repository;

import br.com.etechoracio.academia.entity.ExercicioFisico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExercicioRepository extends JpaRepository<ExercicioFisico, Long> {

    List<ExercicioFisico> findByAprovadoTrue();

}