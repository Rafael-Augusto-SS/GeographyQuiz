CREATE TABLE quiz (
    id INT NOT NULL auto_increment PRIMARY KEY,
    perguntas TEXT,
    pergunta_atual_id INT,
    jogador_atual_id INT,
    pontuacao INT,
    nota INT,
    data_hora DATETIME,
    FOREIGN KEY (pergunta_atual_id) REFERENCES pergunta(id),
    FOREIGN KEY (jogador_atual_id) REFERENCES usuario(id)
);