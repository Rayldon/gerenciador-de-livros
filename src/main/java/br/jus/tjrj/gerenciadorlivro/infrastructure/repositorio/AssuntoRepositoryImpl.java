package br.jus.tjrj.gerenciadorlivro.infrastructure.repositorio;

import br.jus.tjrj.gerenciadorlivro.domain.entidade.Assunto;
import br.jus.tjrj.gerenciadorlivro.domain.repositorio.AssuntoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class AssuntoRepositoryImpl implements AssuntoRepository {

    private SpringAssuntoRepository repository;

    public AssuntoRepositoryImpl(SpringAssuntoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Assunto> consultaPaginada(String descricao, Pageable pageable) {
        return repository.findByDescricaoContaining(descricao, pageable);
    }

    @Override
    public Assunto salvar(Assunto assunto) {
        return repository.save(assunto);
    }

    @Override
    public void excluirPorId(Long id) {
        repository.deleteById(id);
    }
}
