package br.jus.tjrj.gerenciadorlivro.domain.repositorio;

import br.jus.tjrj.gerenciadorlivro.domain.entidade.Autor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface AutorRepository {
    Page<Autor> consultaPaginada(String descricao, Pageable pageable);

    List<Autor> buscarTodos();

    Autor salvar(Autor autor);

    void excluirPorId(Long id);

    Autor buscarPorId(Long id);

    Set<Autor> buscarAutoresPorIds(Set<Long> ids);
}
