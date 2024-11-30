package br.jus.tjrj.gerenciadorlivro.infrastructure.repositorio;

import br.jus.tjrj.gerenciadorlivro.adapters.dto.AutoCompleteDTO;
import br.jus.tjrj.gerenciadorlivro.domain.entidade.Assunto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface SpringAssuntoRepository extends JpaRepository<Assunto, Long> {
    Page<Assunto> findByDescricaoContaining(String descricao, Pageable pageable);

    Set<Assunto> findByIdIn(Set<Long> ids);

    @Query("SELECT new br.jus.tjrj.gerenciadorlivro.adapters.dto.AutoCompleteDTO(a.id, a.descricao) FROM Assunto a WHERE LOWER(a.descricao) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<AutoCompleteDTO> findByQuery(String query, Pageable pageable);
}
