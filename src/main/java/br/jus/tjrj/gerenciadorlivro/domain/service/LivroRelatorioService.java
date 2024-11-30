package br.jus.tjrj.gerenciadorlivro.domain.service;

import br.jus.tjrj.gerenciadorlivro.domain.entidade.LivroRelatorio;
import br.jus.tjrj.gerenciadorlivro.domain.repositorio.LivroRelatorioRepository;
import br.jus.tjrj.gerenciadorlivro.infrastructure.utils.JasperReportsUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LivroRelatorioService {

    private final LivroRelatorioRepository livroRelatorioRepository;
    private final JasperReportsUtils jasperReportsUtils;

    public LivroRelatorioService(LivroRelatorioRepository livroRelatorioRepository, JasperReportsUtils jasperReportsUtils) {
        this.livroRelatorioRepository = livroRelatorioRepository;
        this.jasperReportsUtils = jasperReportsUtils;
    }

    public byte[] gerarRelatorio(){
        List<LivroRelatorio> livros = livroRelatorioRepository.buscarTodos();
        return jasperReportsUtils.gerarRelatorio(livros, "Relatório de Livros");
    }
}
