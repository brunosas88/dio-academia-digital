package me.dio.academiadigital.matricula.repository;

import me.dio.academiadigital.matricula.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Integer>, JpaSpecificationExecutor<Matricula> {
}
