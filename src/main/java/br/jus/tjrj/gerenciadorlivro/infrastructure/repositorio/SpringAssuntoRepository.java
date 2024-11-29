package br.jus.tjrj.gerenciadorlivro.infrastructure.repositorio;

import br.jus.tjrj.gerenciadorlivro.domain.entidade.Assunto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringAssuntoRepository extends JpaRepository<Assunto, Long> {
    Page<Assunto> findByDescricaoContaining(String descricao, Pageable pageable);
}
