# 🧩 URL Shortener API

Uma aplicação simples para encurtar URLs, construída com **Spring Boot**, com persistência opcional em memória (H2) e pronta para execução em container Docker.

---

## 🚀 Funcionalidades

- Encurtar URLs longas com identificadores únicos curtos
- Redirecionar acessos para a URL original
- Contabilizar número de acessos por URL
- Containerizada com Docker
- Persistência com JPA e H2 (pode ser substituída por outro banco relacional)

---

## 📦 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database (em memória)
- Docker / Dockerfile

---

## ▶️ Como Executar Localmente

### Pré-requisitos

- Java 17+
- Maven 3.9+
- Docker (para execução containerizada)

### Executando com Maven

```bash
mvn spring-boot:run
```

A aplicação estará disponível em:
```📍 http://localhost:8080```

### Executando com Docker

```bash
docker build -t url-shortener .
docker run -p 8080:8080 url-shortener
```

---

## 📚 Endpoints da API

**POST /api/shorten** 
Encurta uma URL
Request Body:

```json
{
  "url": "https://exemplo.com"
}
```
Response:

```json
{
  "shortUrl": "http://localhost:8080/abc123"
}
```

**GET /{id}**
Redireciona para a URL original

Exemplo:
GET http://localhost:8080/abc123
➡️ Redireciona para https://exemplo.com

---

## 🛠️ Configurações do Banco
O projeto utiliza H2 em memória por padrão. Para acessar o console:

- Habilite no application.properties:

```properties
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

- Acesse: http://localhost:8080/h2-console
- Use o JDBC URL: jdbc:h2:mem:testdb

---

## 📌 Possíveis Melhorias Futuras

- Suporte a expiração de URLs
- Customização de aliases
- Autenticação e painéis de estatísticas
- Persistência com banco real (PostgreSQL, MySQL, etc.)
- Página frontend simples

---

## 👨‍💻 Autor
Danilo Takeo Kanizawa
