package br.jus.tjrj.gerenciadorlivro.infrastructure.repositorio;

import br.jus.tjrj.gerenciadorlivro.domain.entidade.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringAutorRepository extends JpaRepository<Livro, Long> {
}
