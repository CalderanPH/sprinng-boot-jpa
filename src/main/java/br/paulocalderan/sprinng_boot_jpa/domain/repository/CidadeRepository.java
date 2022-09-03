package br.paulocalderan.sprinng_boot_jpa.domain.repository;

import br.paulocalderan.sprinng_boot_jpa.domain.entity.Cidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    List<Cidade> findByNome(String nome);

    @Query("select cid from Cidade cid where upper(cid.nome) like upper(?1) ")
    List<Cidade> findByNomeLike(String nome, Sort sort);

    @Query("select cid from Cidade cid where upper(cid.nome) like upper(?1) ")
    Page<Cidade> findByNomeLike(String nome, Pageable sort);

    List<Cidade> findBynomeEndingWith(String nome);

    List<Cidade> findByHabitantes(long habitantes);

    List<Cidade> findByHabitantesLessThanAndNomeLike(long habitantes, String nome);




}
