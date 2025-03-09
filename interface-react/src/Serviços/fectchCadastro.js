// src/services/usuarioService.js

const API_URL = 'http://localhost:8080/api/usuarios/cadastro';

export const cadastrarUsuario = async (usuarioData) => {
    try {
        const response = await fetch(API_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(usuarioData),
        });

        if (!response.ok) {
            throw new Error('Erro ao cadastrar usuário');
        }

        const data = await response.json();
        return data; // Retorna a resposta da API
    } catch (err) {
        console.error('Erro:', err);
        throw err; // Lança o erro para ser tratado pelo componente que chamou
    }
};
