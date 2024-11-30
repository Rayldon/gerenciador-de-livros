package br.jus.tjrj.gerenciadorlivro.infrastructure.repositorio;

import br.jus.tjrj.gerenciadorlivro.domain.entidade.LivroRelatorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringLivroRelatorioRepository extends JpaRepository<LivroRelatorio, Long> {

}
