package br.paulocalderan.sprinng_boot_jpa.domain.service;

import br.paulocalderan.sprinng_boot_jpa.domain.entity.Cidade;
import br.paulocalderan.sprinng_boot_jpa.domain.repository.CidadeRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CidadeService {
    private CidadeRepository repository;

    public CidadeService(CidadeRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void salvarCidades() {
        var cidade = new Cidade(1L, "São Paulo", 5544886654L);
        repository.save(cidade);
    }

    public void listarCidadesPorQuantidadeHabitantes() {
        repository.findByHabitantesLessThanAndNomeLike(100000L, "Br%")
                .forEach(System.out::println);
    }

    public void listarCidadesPorNome() {
        Pageable pageable = PageRequest.of(0, 10);
        repository.findByNomeLike("%%%%", pageable)
                .forEach(System.out::println);
    }

    public void listarCidadesPorHabitantes() {
        repository.findByHabitantes(15566666L)
                .forEach(System.out::println);
    }

    public void listarCidades() {
        repository.findAll().forEach(System.out::println);
    }

    // TODO: 9/3/2022 Entender mais sobre os Example e Matcher
    public List<Cidade> filtroDinamico(Cidade cidade) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);
        Example<Cidade> example = Example.of(cidade, matcher);
        return repository.findAll(example);
    }

}
