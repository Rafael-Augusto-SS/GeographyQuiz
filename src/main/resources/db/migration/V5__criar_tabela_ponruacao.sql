create table pontuacao (
  id INT NOT NULL auto_increment PRIMARY KEY,
  pontuacao int not null,
  quiz_atual_id INT,
  usuario_id INT,
  FOREIGN KEY (usuario_id) REFERENCES usuario(id),
  FOREIGN KEY (quiz_id) REFERENCES quiz(id)
);
