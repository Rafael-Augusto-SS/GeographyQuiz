create table pergunta (
  id INT NOT NULL auto_increment PRIMARY KEY,
  texto VARCHAR(300) NOT NULL,
  resposta_correta VARCHAR(300) NOT NULL,
  respostas TEXT
  quiz_atual_id INT
  FOREIGN KEY (quiz_atual_id) REFERENCES quiz(id),
  );