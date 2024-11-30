INSERT INTO tb_autor (nome)
VALUES
    ('Gabriel García Márquez'),
    ('Haruki Murakami'),
    ('J.K. Rowling'),
    ('Jane Austen'),
    ('George Orwell'),
    ('Charles Dickens'),
    ('Franz Kafka'),
    ('Mark Twain'),
    ('Virginia Woolf'),
    ('Leo Tolstoy');

INSERT INTO tb_assunto (Descricao)
VALUES
    ('Literatura'),
    ('Ficção Científica'),
    ('Romance'),
    ('História'),
    ('Filosofia'),
    ('Psicologia'),
    ('Poesia'),
    ('Aventura'),
    ('Mistério'),
    ('Política');

INSERT INTO tb_livro (titulo, edicao, editora, ano_publicacao)
VALUES
    ('Cem Anos de Solidão', 1, 'Editora X', 1967),
    ('Norwegian Wood', 2, 'Editora Y', 1987),
    ('Harry Potter e a Pedra Filosofal', 1, 'Rocco', 1997),
    ('Orgulho e Preconceito', 1, 'Editora Z', 1813),
    ('1984', 1, 'Editora W', 1949),
    ('Oliver Twist', 1, 'Editora V', 1837),
    ('A Metamorfose', 1, 'Editora U', 1915),
    ('As Aventuras de Huckleberry Finn', 1, 'Editora T', 1884),
    ('Mrs. Dalloway', 1, 'Editora S', 1925),
    ('Guerra e Paz', 1, 'Editora R', 1869);

INSERT INTO tb_livro_autor (Livro_Cod, Autor_Cod_Au)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5),
    (6, 6),
    (7, 7),
    (8, 8),
    (9, 9),
    (10, 10);

INSERT INTO tb_livro_assunto (livro_cod, assunto_cod_As)
VALUES
    (1, 1),
    (2, 4),
    (3, 5),
    (4, 1),
    (5, 1),
    (6, 1),
    (7, 1),
    (8, 8),
    (9, 1),
    (10, 4);
