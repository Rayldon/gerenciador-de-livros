package br.jus.tjrj.gerenciadorlivro.infrastructure.repositorio;

import br.jus.tjrj.gerenciadorlivro.domain.entidade.Autor;
import br.jus.tjrj.gerenciadorlivro.domain.repositorio.AutorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class AutorRepositoryImpl implements AutorRepository {

    private SpringAutorRepository repository;

    public AutorRepositoryImpl(SpringAutorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Autor> consultaPaginada(String nome, Pageable pageable) {
        return repository.findByNomeContaining(nome, pageable);
    }

    @Override
    public Autor salvar(Autor autor) {
        return repository.save(autor);
    }

    @Override
    public void excluirPorId(Long id) {
        repository.deleteById(id);
    }
}
