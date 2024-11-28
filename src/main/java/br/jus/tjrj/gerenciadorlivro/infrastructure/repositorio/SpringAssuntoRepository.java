package br.jus.tjrj.gerenciadorlivro.infrastructure.repositorio;

import br.jus.tjrj.gerenciadorlivro.domain.entidade.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringAssuntoRepository extends JpaRepository<Livro, Long> {
}
