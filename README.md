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

## Dependentes:

## Cadastro de dependente `POST`

```
/dependentes/cadastrar
```

### Exemplo de Corpo da Requisição

```json
{
  "nome": "Carlos Souza",
  "email": "carlos.souza@example.com",
  "telefone": "+5511988887777",
  "administradorId": 1
}
```

> Todos os parâmetros são obrigatórios.  
> O campo `email` deve ser um endereço de e-mail válido.  
> O campo `administradorId` deve ser um ID válido de um administrador existente.  

## Atualizar dependente `PUT`

```
/dependentes
```

### Exemplo de Corpo da Requisição

```json
{
  "id": 10,
  "nome": "Carlos Souza",
  "email": "carlos.souza@example.com",
  "telefone": "+5511988887777"
}
```

> O campo `id` é obrigatório e deve corresponder a um dependente existente.  
> Os campos `nome`, `email` e `telefone` são opcionais, mas caso fornecidos, devem ser válidos.  

## Listar todos os dependentes `GET`

```
/dependentes
```

### Exemplo de Requisição

```
GET /dependentes
```

### Exemplo de Resposta

**Status: `200 OK`**

```json
[
  {
    "id": 10,
    "nome": "Carlos Souza",
    "email": "carlos.souza@example.com",
    "telefone": "+5511988887777"
  },
  {
    "id": 11,
    "nome": "Mariana Lima",
    "email": "mariana.lima@example.com",
    "telefone": "+5511977776666"
  }
]
```

> Retorna uma lista com todos os dependentes cadastrados.  
> Se não houver dependentes cadastrados, a resposta será `204 No Content`.

---

## Listar dependentes por administrador `GET`

```
/dependentes/administrador/{id}
```

### Parâmetros de Caminho

| Parâmetro       | Tipo  | Descrição                                      |
|-----------------|-------|------------------------------------------------|
| `id`           | Long  | ID do administrador para filtrar dependentes  |

### Exemplo de Requisição

```
GET /dependentes/administrador/1
```

### Exemplo de Resposta

**Status: `200 OK`**

```json
[
  {
    "id": 10,
    "nome": "Carlos Souza",
    "email": "carlos.souza@example.com",
    "telefone": "+5511988887777"
  }
]
```

> Retorna uma lista com os dependentes do administrador informado.  
> Se o administrador não tiver dependentes, a resposta será `204 No Content`.

---

## Detalhar dependente por ID `GET`

```
/dependentes/{id}
```

### Parâmetros de Caminho

| Parâmetro  | Tipo  | Descrição                         |
|------------|-------|----------------------------------|
| `id`       | Long  | ID do dependente a ser buscado |

### Exemplo de Requisição

```
GET /dependentes/10
```

### Exemplo de Resposta

**Status: `200 OK`**

```json
{
  "id": 10,
  "nome": "Carlos Souza",
  "email": "carlos.souza@example.com",
  "telefone": "+5511988887777"
}
```

> Retorna os detalhes do dependente correspondente ao `id` informado.  
> Se o dependente não for encontrado, a resposta será `204 No Content`.
