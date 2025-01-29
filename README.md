# Documentação dos Endpoints

## Usuários:

## Cadastro de usuário `POST`

```
/usuarios/cadastro
```

### Exemplo de Corpo da Requisição

```json
{
  "nome": "João Silva",
  "email": "joao.silva@example.com",
  "dataNascimento": "1990-05-20",
  "numeroTelefone": "+5511999999999",
  "nomeUsuario": "joaosilva",
  "senha": "senhaSegura123",
  "categoria": "PESSOAL"
}
```

> Todos os parâmetros são obrigatórios

> Categoria aceita apenas (PESSOAL ou ADMINISTRADOR) 

## Listar todos os usuários `GET`

```
/usuarios
```

> Em vez de listá-los de uma única vez, estou utilizando paginação do Spring Boot, então você pode passar alguns parâmetros.

### Parâmetros de Consulta

| Parâmetro | Tipo  | Descrição |
|------------|-------|-------------|
| `page`     | int   | Número da página (começa do 0) |
| `size`     | int   | Quantidade de itens por página (padrão: 10) |
| `sort`     | String | Campo para ordenação (padrão: nome) |

### Exemplo de Requisição

```
GET /usuarios?page=0&size=10&sort=nome
```

### Exemplo de Resposta

```json
{
  "content": [
    {
      "id": 1,
      "nome": "João Silva",
      "email": "joao.silva@example.com"
    },
    {
      "id": 2,
      "nome": "Maria Souza",
      "email": "maria.souza@example.com"
    }
  ],
  "totalElements": 50,
  "totalPages": 5,
  "size": 10,
  "number": 0
}
```

## Detalhar um usuário `GET`

```
/usuarios/{id}
```

### Parâmetros da Requisição

| Parâmetro | Tipo  | Descrição |
|------------|-------|-------------|
| `id`       | long  | ID do usuário a ser detalhado |

### Exemplo de Requisição

```
GET /usuarios/1
```

### Exemplo de Resposta

```json
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao.silva@example.com",
  "dataNascimento": "1990-05-20",
  "numeroTelefone": "+5511999999999",
  "nomeUsuario": "joaosilva",
  "categoria": "PESSOAL"
}
```

## Medicamentos:


