-- Criação da tabela de usuários
CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

-- Inserção de dados de exemplo
INSERT INTO users (username, email)
VALUES
    ('usuario1', 'usuario1@example.com'),
    ('usuario2', 'usuario2@example.com'),
    ('usuario3', 'usuario3@example.com');
