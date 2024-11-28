package br.jus.tjrj.gerenciadorlivro.domain.repositorio;

import br.jus.tjrj.gerenciadorlivro.domain.entidade.Livro;

import java.util.List;
import java.util.Optional;

public interface LivroRepository {
    Livro salvar(Livro livro);
    Optional<Livro> buscarPorId(Long id);
    List<Livro> buscarTodos();
    void remover(Long id);
}
