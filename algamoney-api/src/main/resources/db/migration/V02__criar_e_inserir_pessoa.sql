CREATE TABLE pessoa(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50),
	ativo BIT,
	logradouro VARCHAR(50),
	numero VARCHAR(10),
	complemento VARCHAR(50),
	bairro VARCHAR(50),
	cep VARCHAR(9),
	cidade VARCHAR(50),
	estado VARCHAR(2)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) values ("Rodrigo Coradi",1,"Fagundes Varela","1791","Casa","Vila Ribeiro","19802-152","Assis","SP");
INSERT INTO pessoa (nome,ativo,logradouro,numero,bairro,cep,cidade,estado) values ("Maria",1,"Fagundes Varela","1793","Vila Ribeiro","19802-152","Assis","SP");
INSERT INTO pessoa (nome,ativo,cidade,estado) values ("Lilian",1,"Assis","SP");
INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) values ("Mario",1,"Avenida Perimetral","1191","AP","Centro","19800-000","Assis","SP");
INSERT INTO pessoa (nome,ativo,logradouro,numero) values ("Cida",1,"Fagundes Varela","1791");
INSERT INTO pessoa (nome,ativo) values ("Alice",1);
INSERT INTO pessoa (nome,ativo,logradouro,numero,bairro,cidade,estado) values ("Lucas",1,"Pertin daqui","032","Vila Ribeiro","Assis","SP");
INSERT INTO pessoa (nome,ativo,logradouro) values ("Ana",1,"Samuel Gusmao");
INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) values ("Geraldo",1,"Fagundes Varela","1891","Casa","Vila Ribeiro","19803-150","Assis","SP");
INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) values ("Angela",1,"Gatinho da Silva","321","AP","Orestes","19800-235","Assis","SP");