CREATE TABLE Livro (
   Codl INTEGER PRIMARY KEY NOT NULL,
   Titulo VARCHAR(40) NOT NULL,
   Editora VARCHAR(40),
   Edicao INTEGER,
   AnoPublicacao VARCHAR(4)
);

CREATE TABLE Autor (
   CodAu INTEGER PRIMARY KEY NOT NULL,
   Nome VARCHAR(40) NOT NULL
);

CREATE TABLE Livro_Autor (
     Livro_Cod INTEGER NOT NULL,
     Autor_CodAu INTEGER NOT NULL,
     PRIMARY KEY (Livro_Cod, Autor_CodAu),
     CONSTRAINT fk_livro FOREIGN KEY (Livro_Cod) REFERENCES Livro (Codl),
     CONSTRAINT fk_autor FOREIGN KEY (Autor_CodAu) REFERENCES Autor (CodAu)
);

CREATE TABLE Assunto (
     codAs INTEGER PRIMARY KEY NOT NULL,
     Descricao VARCHAR(20) NOT NULL
);

CREATE TABLE Livro_Assunto (
   Livro_Cod INTEGER NOT NULL,
   Assunto_codAs INTEGER NOT NULL,
   PRIMARY KEY (Livro_Cod, Assunto_codAs),
   CONSTRAINT fk_livro_assunto FOREIGN KEY (Livro_Cod) REFERENCES Livro (Codl),
   CONSTRAINT fk_assunto FOREIGN KEY (Assunto_codAs) REFERENCES Assunto (codAs)
);
