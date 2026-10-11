CREATE TABLE endereco (
                          id UUID PRIMARY KEY,
                          cep VARCHAR(8) NOT NULL,
                          logradouro VARCHAR(100) NOT NULL,
                          numero VARCHAR(10) NOT NULL,
                          bairro VARCHAR(60) NOT NULL,
                          cidade VARCHAR(60) NOT NULL,
                          uf VARCHAR(2) NOT NULL
);

CREATE TABLE adotante (
                          id UUID PRIMARY KEY,
                          nome VARCHAR(80) NOT NULL,
                          email VARCHAR(100) NOT NULL UNIQUE,
                          telefone VARCHAR(15) NOT NULL,
                          endereco_id UUID NOT NULL UNIQUE REFERENCES endereco(id),
                          data_cadastro TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);