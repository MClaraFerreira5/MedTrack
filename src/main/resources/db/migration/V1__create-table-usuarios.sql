CREATE TABLE usuarios (
                          id BIGSERIAL PRIMARY KEY,
                          tipo_conta VARCHAR(100) NOT NULL,
                          nome VARCHAR(100) NOT NULL,
                          email VARCHAR(100) NOT NULL,
                          senha VARCHAR(255) NOT NULL,
                          dataNascimento DATE NOT NULL,
                          nome_usuario VARCHAR(100) NOT NULL UNIQUE
);
