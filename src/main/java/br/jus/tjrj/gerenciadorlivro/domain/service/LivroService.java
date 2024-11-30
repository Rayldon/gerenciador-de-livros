package br.jus.tjrj.gerenciadorlivro.domain.service;

import br.jus.tjrj.gerenciadorlivro.adapters.dto.LivroDTO;
import br.jus.tjrj.gerenciadorlivro.adapters.mapper.LivroMapper;
import br.jus.tjrj.gerenciadorlivro.domain.entidade.Autor;
import br.jus.tjrj.gerenciadorlivro.domain.entidade.Livro;
import br.jus.tjrj.gerenciadorlivro.domain.repositorio.AssuntoRepository;
import br.jus.tjrj.gerenciadorlivro.domain.repositorio.AutorRepository;
import br.jus.tjrj.gerenciadorlivro.domain.repositorio.LivroRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LivroService {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;
    private final AssuntoRepository assuntoRepository;

    public LivroService(LivroRepository livroRepository, AutorRepository autorRepository, AssuntoRepository assuntoRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
        this.assuntoRepository = assuntoRepository;
    }

    public Livro salvar(LivroDTO livroDTO) {
        Livro livro = LivroMapper.INSTANCE.toEntity(livroDTO);
        return livroRepository.salvar(livro);
    }

    public Page<Livro> buscarLivros(String titulo, Pageable pageable) {
        return livroRepository.consultaPaginada(titulo, pageable);
    }

    public void excluirLivro(Long id) {
        livroRepository.excluirPorId(id);
    }
}
