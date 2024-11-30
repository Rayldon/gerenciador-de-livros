package br.jus.tjrj.gerenciadorlivro.domain.repositorio;

import br.jus.tjrj.gerenciadorlivro.domain.entidade.Assunto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface AssuntoRepository {
    Page<Assunto> consultaPaginada(String nome, Pageable pageable);

    Assunto salvar(Assunto assunto);

    void excluirPorId(Long id);

    List<Assunto> buscarTodos();

    Set<Assunto> buscarAutoresPorIds(Set<Long> ids);
}
