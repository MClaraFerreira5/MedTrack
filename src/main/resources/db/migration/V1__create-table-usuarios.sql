CREATE TABLE usuarios (
                          id BIGSERIAL PRIMARY KEY,
                          tipo_conta VARCHAR(100) NOT NULL,
                          nome VARCHAR(100) NOT NULL,
                          email VARCHAR(100) NOT NULL,
                          senha_hashed VARCHAR(255) NOT NULL,
                          data_Nascimento DATE NOT NULL,
                          nome_usuario VARCHAR(100) NOT NULL UNIQUE
);
