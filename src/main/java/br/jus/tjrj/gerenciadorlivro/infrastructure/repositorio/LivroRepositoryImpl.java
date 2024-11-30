package br.jus.tjrj.gerenciadorlivro.infrastructure.repositorio;

import br.jus.tjrj.gerenciadorlivro.domain.entidade.Livro;
import br.jus.tjrj.gerenciadorlivro.domain.repositorio.LivroRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class LivroRepositoryImpl implements LivroRepository {

    private final SpringLivroRepository repository;

    public LivroRepositoryImpl(SpringLivroRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Livro> consultaPaginada(String titulo, Pageable pageable) {
        return repository.findByTituloContaining(titulo, pageable);
    }

    @Override
    public Livro salvar(Livro livro) {
        return repository.save(livro);
    }

    @Override
    public void excluirPorId(Long id) {
        repository.deleteById(id);
    }
}
