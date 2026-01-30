CREATE TABLE atendimentos
(
    id       UUID PRIMARY KEY,
    usuario  VARCHAR(50)   NOT NULL,
    pergunta VARCHAR(500)  NOT NULL,
    resposta VARCHAR(2000) NOT NULL,
    datahora TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)