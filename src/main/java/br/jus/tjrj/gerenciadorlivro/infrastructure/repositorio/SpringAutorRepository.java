package br.jus.tjrj.gerenciadorlivro.infrastructure.repositorio;

import br.jus.tjrj.gerenciadorlivro.domain.entidade.Autor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface SpringAutorRepository extends JpaRepository<Autor, Long> {
    Page<Autor> findByNomeContaining(String nome, Pageable pageable);

    Set<Autor> findByIdIn(Set<Long> ids);
}
