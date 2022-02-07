# SigaBem Calculo de Frete 
Na pasta raiz desse projeto, onde encontra-se o arquivo docker-compose.yaml, o banco de dados deve ser iniciado via docker, utilizando o cmd/terminal, com o comando:

> docker-compose up -d

Verificar possíveis conflitos de porta, caso já haja alguma instancia usando a porta 5432 do localhost.

Para parar o servidor, utilizar o comando:

> docker-compose down

# Dados de conexão

A imagem docker contem à seguinte configuração:
  - host: localhost
  - port: 5432
  - database: sigabem
  - user: admin
  - password: admin

# Requests
 - Consulta de Frete
    - URL: http://localhost:8080/frete
    - Exemplo de Request: (JSON)
    > ```json 
    > { 
    >   "peso": "40", 
    >   "cepOrigem": "61648-030",
    >   "cepDestino": "62820-000",
    >   "nomeDestinatario": "João"
    > }
 - Resultado da Consulta
   > ```json 
    > { 
    >   "vlTotalFrete": 10.0,
    >   "cepOrigem": "61648-030",
    >   "cepDestino": "62820-000",
    >   "dataPrevistaEntrega": "10/02/2022"
    > }
 - Ver Fretes Calculados:
    - URL: http://localhost:8080/frete/list
    - Vai retornar a lista de fretes já calculados


