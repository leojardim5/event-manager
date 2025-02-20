![image](https://github.com/user-attachments/assets/eccd9f57-47f8-4e60-8504-2c4e1ee8e7da)📌 Event Manager

Este projeto é um Gerenciador de Eventos desenvolvido com Java Spring Boot e PostgreSQL, utilizando Docker para facilitar a 
configuração do ambiente. Ele permite gerenciar usuários, eventos e inscrições, gerando automaticamente dados fictícios.

📂 Estrutura do Projeto

event-manager/
│-- docker-compose.yml      # Configuração do Docker Compose
│-- Dockerfile              # Configuração do container da aplicação
│-- db/
│   ├── init.sql            # Script SQL para criar tabelas e dados fictícios
│-- src/
│   ├── main/
│       ├── java/com/leonardo/eventosManager/
│           ├── controllers/ # Controladores REST
│           ├── models/      # Modelos JPA
│           ├── services/    # Lógica de negócio
│           ├── DTO/         # Data Transfer Objects
│           ├── config/      # Configuração da aplicação
│           ├── JavaEstudoApplication.java  # Classe principal
│-- .env.example             # Exemplo de variáveis de ambiente
│-- README.md                # Documentação do projeto
│-- pom.xml                  # Dependências do Maven

🚀 Como rodar o projeto

1️⃣ Clonar o repositório
git clone https://github.com/seu-usuario/event-manager.git
cd event-manager

2️⃣ Configurar variáveis de ambiente

Crie um arquivo .env na raiz do projeto e defina as variáveis conforme necessário. Exemplo:
DB_URL=jdbc:postgresql://localhost:5432/exemplo
DB_USER=seu_usuario
DB_PASS=sua_senha

3️⃣ Subir os containers Docker
docker-compose up -d --build

Isso irá:
✔ Criar e rodar um container PostgreSQL
✔ Criar e rodar um container para o backend
✔ Aplicar as migrações e popular o banco de dados com usuários e eventos fictícios

4️⃣ Acessar a API

A aplicação estará rodando em http://localhost:8080.

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

🛠 Tecnologias Utilizadas

Java 17 + Spring Boot
PostgreSQL (banco de dados)
Docker + Docker Compose (containerização)
Maven (gerenciador de dependências)
Spring Data JPA (para persistência no banco)
Spring Web (API REST)

🔄 Parar os containers
Se precisar parar a aplicação, basta rodar:
docker-compose down

Isso não apaga os dados do banco de dados. Se quiser apagar tudo e começar do zero, use:
docker-compose down -v
Isso removerá os volumes e apagará os dados do banco.



