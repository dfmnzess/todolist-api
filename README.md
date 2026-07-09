# 📝 To-Do List API

API REST para gerenciamento de tarefas, desenvolvida com Spring Boot. Projeto criado para praticar arquitetura em camadas, boas práticas REST e tratamento de erros.

## 🚀 Tecnologias

- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 Database
- Bean Validation
- Maven

## 📋 Funcionalidades

- Criar, listar, atualizar e remover tarefas
- Marcar tarefas como concluídas
- Filtrar tarefas por status ou prioridade
- Validação de campos obrigatórios
- Tratamento de erros padronizado (404, 400)

## 🔗 Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/tasks` | Cria uma nova tarefa |
| GET | `/tasks` | Lista todas as tarefas |
| GET | `/tasks?priority=HIGH` | Filtra tarefas por prioridade |
| GET | `/tasks/{id}` | Busca uma tarefa por id |
| PUT | `/tasks/{id}` | Atualiza uma tarefa |
| PATCH | `/tasks/{id}/complete` | Marca uma tarefa como concluída |
| DELETE | `/tasks/{id}` | Remove uma tarefa |

## 📦 Exemplo de requisição

**POST** `/tasks`

```json
{
  "title": "Estudar Spring Boot",
  "description": "Revisar controllers e services",
  "priority": "HIGH",
  "dueDate": "2026-07-15"
}
```

**Resposta (201 Created)**

```json
{
  "id": 1,
  "title": "Estudar Spring Boot",
  "description": "Revisar controllers e services",
  "completed": false,
  "priority": "HIGH",
  "dueDate": "2026-07-15",
  "createdAt": "2026-07-08T22:13:37"
}
```

## ⚙️ Como rodar o projeto

Pré-requisitos: Java 17 e Maven instalados.

```bash
git clone https://github.com/dfmnzess/todolist-api.git
cd todolist-api
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

O console do banco H2 pode ser acessado em `http://localhost:8080/h2-console`  
(JDBC URL: `jdbc:h2:mem:tododb`, usuário: `sa`, sem senha).

## 🧱 Arquitetura

Projeto organizado em camadas seguindo boas práticas REST:

controller/  → recebe requisições HTTP
service/     → regras de negócio
repository/  → acesso a dados (Spring Data JPA)
model/       → entidades JPA
dto/         → objetos de entrada e saída da API
exception/   → tratamento centralizado de erros

## 👤 Autor

**Davi Freire de Menezes**  
Estudante de Engenharia de Software na UDESC  
[GitHub](https://github.com/dfmnzess)