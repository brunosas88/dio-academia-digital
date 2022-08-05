package me.dio.academiadigital.matricula.repository;

import me.dio.academiadigital.matricula.model.Matricula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Integer>, JpaSpecificationExecutor<Matricula> {
    Matricula findByAlunoCpf(String cpf);
    Matricula findByMatriculaId(String matriculaId);

    @Query(value = "SELECT * FROM matricula m " +
            "INNER JOIN aluno a ON m.aluno_id = a.id " +
            "WHERE a.endereco = :endereco", nativeQuery = true)
        //@Query("FROM Matricula m WHERE m.aluno.endereco = :endereco ")
    Page<Matricula> findAlunosMatriculadosEndereco(String endereco, Pageable pageable);

}
