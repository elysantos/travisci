DROP TABLE IF EXISTS enderecos;
DROP TABLE IF EXISTS telefones;
DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS veiculos;


CREATE TABLE enderecos (
                              id INT AUTO_INCREMENT  PRIMARY KEY,
                              cep VARCHAR(8) NOT NULL,
                              logradouro VARCHAR(250) NOT NULL,
                              bairro VARCHAR(250) NOT NULL,
                              complemento VARCHAR(250) DEFAULT NULL,
                              numero INT,
                              cidade VARCHAR(50) NOT NULL,
                              uf VARCHAR(2) NOT NULL
);

CREATE TABLE telefones (
                              code VARCHAR(2) NOT NULL,
                              numero VARCHAR(9) NOT NULL,
                              usuario_id INT NOT NULL
);

CREATE TABLE usuarios (
                           id INT AUTO_INCREMENT  PRIMARY KEY,
                           cpf VARCHAR(11) NOT NULL,
                           nome VARCHAR(250) NOT NULL,
                           sexo INT NOT NULL,
                           tipo INT NOT NULL,
                           curso VARCHAR(100) DEFAULT NULL,
                           codigo VARCHAR(40) NOT NULL,
                           empresa VARCHAR(40) DEFAULT NULL,
                           setor VARCHAR(40) DEFAULT NULL,
                           email VARCHAR(250) DEFAULT NULL,
                           endereco_id INT NOT NULL
);

CREATE TABLE veiculos (
                           id INT AUTO_INCREMENT  PRIMARY KEY,
                           marca VARCHAR(11) NOT NULL,
                           modelo VARCHAR(50) NOT NULL,
                           ano INT NOT NULL,
                           placa VARCHAR(10) NOT NULL,
                           selo INT AUTO_INCREMENT,
                           cor VARCHAR(10) NOT NULL,
                           ativo INT DEFAULT 0,
                           usuario_id INT NOT NULL
);

insert into enderecos(id, cep, logradouro, bairro, cidade, uf)
values (1, '65000000', 'Nova Rua', 'Algum Bairro', 'São Luis', 'MA');

insert into usuarios(id, cpf, nome, sexo, tipo, curso, codigo, endereco_id)
values (1, '00011122233', 'John Doe', 0,1, 'Sistemas de Informacao', 'SI14210000',  1),
       (2, '99911122233', 'Jane Doe', 1,2, 'Sistemas de Informacao', 'SI14210000',  1);

insert into telefones(code, numero, usuario_id)
values('98', '911112222', 1),
('98', '982222222', 2);

insert into veiculos(id, marca, modelo, ano, cor, placa, usuario_id)
values (1, 'Renault', 'Logan', '2021', 'azul', 'PPP0000', 1);
