  --CONSULTAS
  
  --Países ordenados por nome decrescente:
  SELECT * 
      FROM VEMSER_PATRICIA.PAIS 
      ORDER BY NOME DESC 
  
  --Logradouro e cep dos endereços. Porém somente os logradouros que comecem com a letra a maiúsculo ou minúsculo
  SELECT LOGRADOURO, CEP 
      FROM VEMSER_PATRICIA.ENDERECO 
      WHERE LOGRADOURO LIKE UPPER ('a%')
  
  --Enderecos que tenham cep com final 0
  SELECT * 
      FROM VEMSER_PATRICIA.ENDERECO 
      WHERE TRIM(CEP) LIKE  '%0'

  --Enderecos que tenham número entre 1 e 100
  SELECT * 
      FROM VEMSER_PATRICIA.ENDERECO 
      WHERE NUMERO BETWEEN 1 AND 100
  
  --Enderecos que comecem por "rua" e ordenar cep de forma decrescente
  SELECT * 
      FROM VEMSER_PATRICIA.ENDERECO 
      WHERE LOGRADOURO LIKE UPPER ('Rua%') 
      ORDER BY CEP DESC
  
  --Selecionar a quantidade de endereços cadastrados na tabela
  SELECT COUNT (*) "Quantidade de endereços: " 
      FROM VEMSER_PATRICIA.ENDERECO
  
  --Selecionar a quantidade de endereços agrupados pela id da cidade 
  SELECT ID_CIDADE, COUNT (*) "Quantidade de endereços: " 
      FROM VEMSER_PATRICIA.ENDERECO 
      GROUP BY ID_CIDADE 
      ORDER BY ID_CIDADE 
