package br.jus.tjrj.gerenciadorlivro.domain.service;

import br.jus.tjrj.gerenciadorlivro.adapters.dto.AutorDTO;
import br.jus.tjrj.gerenciadorlivro.adapters.mapper.AutorMapper;
import br.jus.tjrj.gerenciadorlivro.domain.entidade.Autor;
import br.jus.tjrj.gerenciadorlivro.domain.repositorio.AutorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor salvar(AutorDTO autorDTO) {
        Autor autor = AutorMapper.INSTANCE.toEntity(autorDTO);
        return autorRepository.salvar(autor);
    }

    public Page<Autor> buscarAutores(String nome, Pageable pageable) {
        return autorRepository.consultaPaginada(nome, pageable);
    }

    public void excluirAutor(Long id) {
        autorRepository.excluirPorId(id);
    }
}
