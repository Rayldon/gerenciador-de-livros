package br.jus.tjrj.gerenciadorlivro.domain.repositorio;

import br.jus.tjrj.gerenciadorlivro.domain.entidade.Livro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LivroRepository {
    Page<Livro> consultaPaginada(String titulo, Pageable pageable);

    Livro salvar(Livro livro);

    void excluirPorId(Long id);
}
