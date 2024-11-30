package br.jus.tjrj.gerenciadorlivro.infrastructure.utils;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

;

@Component
public class JasperReportsUtils {

    public <T> byte[] gerarRelatorio(List<T> dados, String titulo) {
        byte[] relatorio = null;
        try {
            InputStream template = new ClassPathResource("relatorios/relatorio_livros.jasper").getInputStream();

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dados);
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("Titulo", titulo);

            JasperPrint jasperPrint = JasperFillManager.fillReport(template, parametros, dataSource);
            relatorio = JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (JRException | IOException e) {
            throw new RuntimeException(e);
        }
        return relatorio;
    }
}
