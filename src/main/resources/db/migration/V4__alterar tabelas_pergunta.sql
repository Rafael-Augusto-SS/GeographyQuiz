ALTER TABLE pergunta ADD quiz_atual_id INT;
ALTER TABLE pergunta ADD FOREIGN KEY (quiz_atual_id) REFERENCES quiz(id);