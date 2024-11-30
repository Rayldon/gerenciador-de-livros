package br.jus.tjrj.gerenciadorlivro.infrastructure.repositorio;


import br.jus.tjrj.gerenciadorlivro.domain.entidade.Assunto;
import br.jus.tjrj.gerenciadorlivro.domain.entidade.Livro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringLivroRepository extends JpaRepository<Livro, Long> {

    Page<Livro> findByTituloContaining(String titulo, Pageable pageable);
}
