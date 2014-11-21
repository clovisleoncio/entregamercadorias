Entrega de Mercadorias
======================

Solução de problema do Wallmart para otimização de logística.

Para a solução foi utilizada arquitetura Java EE simples, apenas com implementações da especificação. O objetivo foi basicamente atender os requisitos sem necessitar de configurações adicionais e mantendo uma linha simples de integração entre os componentes.

Para a definição da regra a implementar, um detalhe não ficou claro: no momento de adicionar mapas é informado o nome do mesmo, mas não na consulta. Neste caso assumi que o grafo completo será formado pela união de várias mapas que poderão ter pontos em comum e podem ser substituídos à medida que seja necessário. Idealmente a atualização do deveria ser parcial mas, para evitar excesso de complexidade sincronizando recursos em memória com recursos em banco de dados (sujeitos à transação) optei por reconstruir o grafo completo.


Execução
========

Baixar o projeto e gerar o pacote com o maven.
Criar no SGBD da sua preferência o banco de dados segundo script abaixo.
Criar no JBoss Wildfly o datasource java:/jdbc/EntregaDS apontando para o banco de dados criado anteriormente.
Realizar o deploy da aplicação.
Os serviços estarão disponíves em: http://localhost:8080/entregamercadorias/service/malhalogistica
  - GET: consulta um caminho com seu custo. Recebe os parâmetros do tipo QUERY abaixo:
    - origem: texto
    - destino: texto
    - autonomia: decimal
    - valorLitro: decimal
  - PUT: adicionar um mapa ao grafo. Recebe os parâmetros do tipo FORM abaixo:
    - nome: texto
    - malha: texto


Script de Criação
=================

CREATE TABLE MAPA (
  NOME VARCHAR(100) PRIMARY KEY
);

CREATE TABLE ROTA (
  ID VARCHAR(100) PRIMARY KEY,
  MAPA VARCHAR(100) REFERENCES MAPA,
  ORIGEM VARCHAR(100),
  DESTINO VARCHAR(100),
  DISTANCIA INTEGER
);
