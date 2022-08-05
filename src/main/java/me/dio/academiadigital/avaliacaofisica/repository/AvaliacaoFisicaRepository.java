package me.dio.academiadigital.avaliacaofisica.repository;

import me.dio.academiadigital.avaliacaofisica.model.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, Integer>, JpaSpecificationExecutor<AvaliacaoFisica> {
}
