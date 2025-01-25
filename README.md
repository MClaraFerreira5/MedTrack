# Documentação dos Endpoints

## Usuários:

- Cadastro de usuário `POST`

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


## Medicamentos:

