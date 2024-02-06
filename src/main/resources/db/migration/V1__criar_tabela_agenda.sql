CREATE TABLE agenda_endereco (
    id SERIAL PRIMARY KEY,
    Logradouro VARCHAR(200) NOT NULL,
    Numero VARCHAR(5) NOT NULL,
    Complemento VARCHAR(200),
    Bairro VARCHAR(100) NOT NULL,
    Cidade VARCHAR(100) NOT NULL,
    Uf VARCHAR(2) NOT NULL
);

CREATE TABLE agenda_contato (
    id SERIAL PRIMARY KEY,
    Celular VARCHAR(20) NOT NULL,
    Email VARCHAR(100),
    Telefone VARCHAR(20)
);

CREATE TABLE agenda (
    id SERIAL PRIMARY KEY,
    Documento VARCHAR(100) NOT NULL,
    Nome VARCHAR(100) NOT NULL,
    id_contato BIGINT,
    id_endereco BIGINT,
    FOREIGN KEY (id_contato) REFERENCES agenda_contato(id),
    FOREIGN KEY (id_endereco) REFERENCES agenda_endereco(id)
);