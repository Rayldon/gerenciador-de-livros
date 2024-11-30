package br.jus.tjrj.gerenciadorlivro.infrastructure.repositorio;

import br.jus.tjrj.gerenciadorlivro.adapters.dto.AutoCompleteDTO;
import br.jus.tjrj.gerenciadorlivro.domain.entidade.Autor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface SpringAutorRepository extends JpaRepository<Autor, Long> {
    Page<Autor> findByNomeContaining(String nome, Pageable pageable);

    Set<Autor> findByIdIn(Set<Long> ids);

    @Query("SELECT new br.jus.tjrj.gerenciadorlivro.adapters.dto.AutoCompleteDTO(a.id, a.nome) FROM Autor a WHERE LOWER(a.nome) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<AutoCompleteDTO> findByQuery(String query, Pageable pageable);
}
