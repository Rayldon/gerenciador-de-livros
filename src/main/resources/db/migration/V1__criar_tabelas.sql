CREATE TABLE tb_livro (
   Codl INTEGER PRIMARY KEY AUTO_INCREMENT,
   Titulo VARCHAR(40) NOT NULL,
   Editora VARCHAR(40),
   Edicao INTEGER,
   Ano_Publicacao VARCHAR(4)
);

CREATE TABLE tb_autor (
   Cod_Au INTEGER PRIMARY KEY AUTO_INCREMENT,
   Nome VARCHAR(40) NOT NULL
);

CREATE TABLE tb_livro_autor (
     Livro_Cod INTEGER NOT NULL,
     Autor_Cod_Au INTEGER NOT NULL,
     PRIMARY KEY (Livro_Cod, Autor_Cod_Au),
     CONSTRAINT fk_livro FOREIGN KEY (Livro_Cod) REFERENCES tb_livro (Codl),
     CONSTRAINT fk_autor FOREIGN KEY (Autor_Cod_Au) REFERENCES tb_autor (Cod_Au)
);

CREATE TABLE tb_assunto (
     cod_As INTEGER PRIMARY KEY AUTO_INCREMENT,
     Descricao VARCHAR(20) NOT NULL
);

CREATE TABLE tb_livro_assunto (
   Livro_Cod INTEGER NOT NULL,
   Assunto_cod_As INTEGER NOT NULL,
   PRIMARY KEY (Livro_Cod, Assunto_cod_As),
   CONSTRAINT fk_livro_assunto FOREIGN KEY (Livro_Cod) REFERENCES tb_livro (Codl),
   CONSTRAINT fk_assunto FOREIGN KEY (Assunto_cod_As) REFERENCES tb_assunto (cod_As)
);
