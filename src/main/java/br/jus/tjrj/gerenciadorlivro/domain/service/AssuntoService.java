package br.jus.tjrj.gerenciadorlivro.domain.service;

import br.jus.tjrj.gerenciadorlivro.adapters.dto.AssuntoDTO;
import br.jus.tjrj.gerenciadorlivro.adapters.mapper.AssuntoMapper;
import br.jus.tjrj.gerenciadorlivro.domain.entidade.Assunto;
import br.jus.tjrj.gerenciadorlivro.domain.repositorio.AssuntoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssuntoService {

    private final AssuntoRepository assuntoRepository;

    public AssuntoService(AssuntoRepository assuntoRepository) {
        this.assuntoRepository = assuntoRepository;
    }

    public Assunto salvar(AssuntoDTO assuntoDTO) {
        Assunto assunto = AssuntoMapper.INSTANCE.toEntity(assuntoDTO);
        return assuntoRepository.salvar(assunto);
    }

    public Page<Assunto> buscarAssuntos(String descricao, Pageable pageable) {
        return assuntoRepository.consultaPaginada(descricao, pageable);
    }

    public void excluirAssunto(Long id) {
        assuntoRepository.excluirPorId(id);
    }

    public List<Assunto> buscarTodosAssuntos() {
        return assuntoRepository.buscarTodos();
    }
}
