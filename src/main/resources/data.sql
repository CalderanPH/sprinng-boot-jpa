CREATE TABLE tb_cidade
(
    id         BIGINT NOT NULL PRIMARY KEY,
    nome       VARCHAR(50),
    habitantes BIGINT
);
INSERT INTO tb_cidade (id, nome, habitantes)
VALUES (1, 'São Paulo', 10000000);
VALUES (2, 'Porto Alegre', 45456632);
VALUES (3, 'Rio de Janeiro', 4564678);
VALUES (4, 'Espirito Santo', 87654654);
VALUES (5, 'Minas', 1232467);