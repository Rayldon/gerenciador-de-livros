package br.jus.tjrj.gerenciadorlivro.domain.service;

import br.jus.tjrj.gerenciadorlivro.adapters.dto.LivroDTO;
import br.jus.tjrj.gerenciadorlivro.adapters.mapper.LivroMapper;
import br.jus.tjrj.gerenciadorlivro.domain.entidade.Livro;
import br.jus.tjrj.gerenciadorlivro.domain.repositorio.LivroRepository;
import br.jus.tjrj.gerenciadorlivro.infrastructure.exception.GerenciadoLivroException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro salvar(LivroDTO livroDTO) {
        validarCamposObrigatorios(livroDTO);
        Livro livro = LivroMapper.INSTANCE.toEntity(livroDTO);
        return livroRepository.salvar(livro);
    }

    public Page<Livro> buscarLivros(String titulo, Pageable pageable) {
        return livroRepository.consultaPaginada(titulo, pageable);
    }

    public void excluirLivro(Long id) {
        livroRepository.excluirPorId(id);
    }

    private void validarCamposObrigatorios(LivroDTO livroDTO) {
        if (livroDTO.getTitulo() == null || livroDTO.getTitulo().isEmpty()) {
            throw new GerenciadoLivroException("O título é obrigatório.");
        }
        if (livroDTO.getEditora() == null || livroDTO.getEditora().isEmpty()) {
            throw new GerenciadoLivroException("A editora é obrigatória.");
        }
        if (livroDTO.getEdicao() == null) {
            throw new GerenciadoLivroException("A edição é obrigatória.");
        }
        if (livroDTO.getAnoPublicacao() == null || livroDTO.getAnoPublicacao().isEmpty()) {
            throw new GerenciadoLivroException("O ano de publicação é obrigatório.");
        }
        if (livroDTO.getValor() == null) {
            throw new GerenciadoLivroException("O valor é obrigatório.");
        }
        if (livroDTO.getAutoresIds() == null || livroDTO.getAutoresIds().isEmpty()) {
            throw new GerenciadoLivroException("Pelo menos um autor deve ser informado.");
        }
        if (livroDTO.getAssuntosIds() == null || livroDTO.getAssuntosIds().isEmpty()) {
            throw new GerenciadoLivroException("Pelo menos um assunto deve ser informado.");
        }
    }
}
