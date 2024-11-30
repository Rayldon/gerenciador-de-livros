package br.jus.tjrj.gerenciadorlivro.infrastructure.repositorio;

import br.jus.tjrj.gerenciadorlivro.domain.entidade.LivroRelatorio;
import br.jus.tjrj.gerenciadorlivro.domain.repositorio.LivroRelatorioRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LivroRelatorioRepositoryImpl implements LivroRelatorioRepository {

    private final SpringLivroRelatorioRepository repository;

    public LivroRelatorioRepositoryImpl(SpringLivroRelatorioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LivroRelatorio> buscarTodos() {
        return repository.findAll();
    }
}
