📌 Event Manager

Este projeto é um Gerenciador de Eventos desenvolvido com Java Spring Boot e PostgreSQL, 
utilizando Docker para facilitar a configuração do ambiente.
Ele permite gerenciar usuários, eventos e inscrições, gerando automaticamente dados fictícios.

📂 Estrutura do Projeto

![image](https://github.com/user-attachments/assets/62d7ec28-c407-476a-847b-f6c30ed0a6cb)

🚀 Como rodar o projeto

![image](https://github.com/user-attachments/assets/3c7c83c9-88e2-412b-954b-1f524e7c5c9b)

🔄 Dados Gerados Automaticamente

O projeto cria automaticamente:
✔ 100 usuários fictícios com nomes reais e e-mails únicos
✔ 5 eventos diferentes
✔ Inscrições aleatórias para cada evento, garantindo que alguns eventos tenham mais participantes do que outros
✔ Distribuição aleatória de organizadores e convidados

📌 Endpoints da API

🧑‍💼 Usuários

GET /usuarios

GET /usuarios/{id}

POST /usuarios

PUT /usuarios/{id}

DELETE /usuarios/{id}

GET /usuarios/{id}/eventos

🎟️ Eventos

GET /eventos

GET /eventos/{id}

POST /eventos

PUT /eventos/{id}

DELETE /eventos/{id}

GET /eventos/{id}/inscritos

📝 Inscrições

GET /inscricoes

GET /inscricoes/{id}

POST /inscricoes/register

DELETE /inscricoes/{id}



