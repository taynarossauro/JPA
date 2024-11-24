# Projeto: Exemplo com JPA e MySQL utilizando WAMP



## 1. Resumo
Este projeto implementa um exemplo prático de utilização do **Java Persistence API (JPA)** para manipulação de dados em um banco de dados MySQL. Foi configurado utilizando dbeaver e localhost, com um projeto Maven contendo todas as dependências necessárias.

---

## 2. Pré-requisitos
- **Java JDK 8 ou superior**.
- **Apache Maven**.
- **WAMP Server** ou outro servidor com suporte ao MySQL.
- IDE como IntelliJ, Eclipse ou NetBeans.

---

## 3. Configuração do Banco de Dados

1. Instale e configure o WAMP (Ou outro servidor de sua preferencia)
2. Acesse o phpMyAdmin e crie um banco de dados chamado `produtos_db`.
3. Execute o seguinte script SQL para criar a tabela:

```sql
CREATE DATABASE IF NOT EXISTS produtos_db

USE produtos_db;

CREATE TABLE produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL
);
