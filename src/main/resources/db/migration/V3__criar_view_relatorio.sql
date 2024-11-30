CREATE VIEW Vw_Livro_Relatorio AS
SELECT
    L.Codl as id_livro,
    L.Titulo,
    L.Editora,
    L.Edicao,
    L.Ano_Publicacao,
    A.Nome AS Autor_Nome,
    S.Descricao AS Assunto_Descricao
FROM
    tb_livro L
        LEFT JOIN
    tb_livro_autor LA ON L.Codl = LA.Livro_Cod
        LEFT JOIN
    tb_autor A ON LA.Autor_Cod_Au = A.Cod_Au
        LEFT JOIN
    tb_livro_assunto LAss ON L.Codl = LAss.Livro_Cod
        LEFT JOIN
    tb_assunto S ON LAss.Assunto_cod_As = S.cod_As;
