package br.jus.tjrj.gerenciadorlivro.infrastructure.repositorio;

import br.jus.tjrj.gerenciadorlivro.domain.entidade.Livro;
import br.jus.tjrj.gerenciadorlivro.domain.repositorio.LivroRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LivroRepositoryImpl implements LivroRepository {

    private final SpringLivroRepository springLivroRepository;

    public LivroRepositoryImpl(SpringLivroRepository springLivroRepository) {
        this.springLivroRepository = springLivroRepository;
    }

    @Override
    public Livro salvar(Livro livro) {
        return springLivroRepository.save(livro);
    }

    @Override
    public Optional<Livro> buscarPorId(Long id) {
        return springLivroRepository.findById(id);
    }

    @Override
    public List<Livro> buscarTodos() {
        return springLivroRepository.findAll();
    }

    @Override
    public void remover(Long id) {
        springLivroRepository.deleteById(id);
    }
}
