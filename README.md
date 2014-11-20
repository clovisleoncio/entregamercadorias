entregamercadorias
==================

Solução de problema do Wallmart para otimização de logística.

Para a solução foi utilizada arquitetura Java EE simples, apenas com implementações da especificação. O objetivo foi basicamente atender os requisitos sem necessitar de configurações adicionais e mantendo uma linha simples de integração entre os componentes.

Para a definição da regra a implementar, um detalhe não ficou claro: no momento de adicionar mapas é informado o nome do mesmo, mas não na consulta. Neste caso assumi que o grafo completo será formado pela união de várias mapas que poderão ter pontos em comum e podem ser substituídos à medida que seja necessário. Idealmente a atualização do deveria ser parcial mas, para evitar excesso de complexidade sincronizando recursos em memória com recursos em banco de dados (sujeitos à transação) optei por reconstruir o grafo completo.
