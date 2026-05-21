# Dengue Zero - Backend

Backend da aplicação Dengue Zero, responsável pelo gerenciamento dos dados da aplicação mobile, integração com Firebase Authentication, armazenamento de imagens e gerenciamento de casos de dengue através de APIs REST.

---

# Objetivo do Projeto

O objetivo do Dengue Zero é auxiliar no acompanhamento, conscientização e monitoramento de casos de dengue, fornecendo uma solução moderna, escalável e integrada entre backend e aplicação mobile.

---

# Tecnologias Utilizadas

- Java 17
- Spring Boot
- PostgreSQL
- JPA/Hibernate
- Firebase Authentication
- Docker
- Maven

---

# Arquitetura

O projeto foi desenvolvido utilizando:

- Arquitetura MVC
- APIs RESTful
- Integração entre Frontend Flutter e Backend Java
- Princípios SOLID
- Estrutura modular e escalável

---

# Funcionalidades

- Autenticação com Google via Firebase Authentication
- Validação de usuários autenticados pelo Firebase
- CRUD de casos de dengue
- Persistência de dados com PostgreSQL
- Containerização da aplicação com Docker

---

# Instrução de Instalação

## Pré-requisitos

Antes de iniciar, instale:

- Java 17
- Maven
- Docker
- Docker Compose
- PostgreSQL (Opcional se for usar o banco de dados de teste)

---

# Configuração do Firebase

## 1. Criar projeto no Firebase

Acesse o Firebase Console e ative:

- Firebase Authentication
- Login com Google

---

## 2. Gerar Service Account

Vá em:

- Configurações do Projeto
- Contas de Serviço
- Gerar nova chave privada

Salve o arquivo como:

```bash
firebase-service-account.json
```

E coloque dentro de:

```bash
src/main/resources/
```

---

# Configuração da Aplicação

No arquivo `application.properties` configure:

```properties
firebase.credentials=COLOCA_AQUI_O_PATH_DO_FIREBASE_SERVICE_ACCOUNT
```

---

# Como Funciona

O backend valida o token do firebase, extrai o token e pega os dados como nome e e-mail armazena no banco de dados da tabela de usuários, seguidamente pode fazer 3 requisições um POST para criar uma denúncia, um GET para exibir as denúncias e um GET para exibir as denúncias por usuário.

## Fluxo da autenticação

1. O Firebase gera um token de autenticação do usuário.
2. O Flutter envia esse token para o backend Java.
3. O backend valida o token utilizando o Firebase Admin SDK.
4. Após a validação:
   - o usuário pode acessar endpoints protegidos
   - registrar casos de dengue
5. Os dados são armazenados no PostgreSQL.

---

# Endpoints da API

## Autenticação

### Validar Token Firebase

```http
POST /users
```

---

## Casos de Dengue

### Criar denúncia

```http
POST /denounces
```

### Listar denúncias

```http
GET /denounces/all
```

### Buscar denúncias por UID

```http
GET /denounces/user
```

---

# Banco de Dados

O projeto utiliza PostgreSQL juntamente com:

- Spring Data JPA
- Hibernate ORM

Responsáveis por:

- Persistência de dados
- Relacionamento entre entidades
- Mapeamento objeto-relacional

---

# Docker

A aplicação utiliza Docker para:

- Padronização do ambiente
- Facilidade no deploy
- Execução simplificada
- Escalabilidade da aplicação
