package br.jus.tjrj.gerenciadorlivro.domain.repositorio;

import br.jus.tjrj.gerenciadorlivro.domain.entidade.Autor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AutorRepository {
    Page<Autor> consultaPaginada(String descricao, Pageable pageable);

    Autor salvar(Autor autor);

    void excluirPorId(Long id);
}
