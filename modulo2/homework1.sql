
--Criando tabela ESTUDANTE
CREATE TABLE VEMSER_PATRICIA.ESTUDANTE (
  id NUMBER NOT NULL, 
  nome VARCHAR(200) NOT NULL, 
  data_nascimento DATE NOT NULL, 
  nr_matricula NUMBER(10) UNIQUE NOT NULL,
  ativo CHAR(1) NOT NULL,
  PRIMARY KEY(id));
 
 --Criando a sequência automática do id
 CREATE SEQUENCE SEQ_ESTUDANTE
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

--Criando os registros dos estudantes
INSERT INTO VEMSER_PATRICIA.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Alice Campos', TO_DATE('18-05-2007', 'dd-mm-yyyy'), 1234567890, 'S');
  
INSERT INTO VEMSER_PATRICIA.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Elisa Silva', TO_DATE('08-10-2007', 'dd-mm-yyyy'), 2345678901, 'S');

INSERT INTO VEMSER_PATRICIA.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Isaac Machado', TO_DATE('07-11-2007', 'dd-mm-yyyy'), 3456789012, 'N');

INSERT INTO VEMSER_PATRICIA.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Nicole Lemez', TO_DATE('10-01-2007', 'dd-mm-yyyy'), 4567890123, 'S');

INSERT INTO VEMSER_PATRICIA.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Vitória Cardoso', TO_DATE('14-02-2007', 'dd-mm-yyyy'), 5678901234, 'S');

INSERT INTO VEMSER_PATRICIA.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Leonardo Silva', TO_DATE('21-12-2007', 'dd-mm-yyyy'), 6789012345, 'S');

INSERT INTO VEMSER_PATRICIA.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Ana Paula Ribeiro', TO_DATE('25-03-2007', 'dd-mm-yyyy'), 7890123456, 'S');

INSERT INTO VEMSER_PATRICIA.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Júlia Costa', TO_DATE('19-05-2007', 'dd-mm-yyyy'), 8901234567, 'S');

INSERT INTO VEMSER_PATRICIA.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'Juliana Campos', TO_DATE('08-09-2007', 'dd-mm-yyyy'), 9012345678, 'S');

INSERT INTO VEMSER_PATRICIA.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.nextval, 'André Souza', TO_DATE('07-08-2007', 'dd-mm-yyyy'), 2255778899, 'S');

--Selecionando todos os estudantes da tabela
SELECT * FROM ESTUDANTE;

--Selecionado estudantes específicos, no caso os ativos
SELECT * FROM ESTUDANTE WHERE ativo = 'S';