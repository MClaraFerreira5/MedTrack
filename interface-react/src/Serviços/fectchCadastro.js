export const cadastrarUsuario = async (formData) => {
    try {
        const response = await fetch('http://localhost:8081/usuarios/cadastro', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData),
        });

        if (!response.ok) {
            throw new Error('Erro ao cadastrar usuário');
        }

        const data = await response.json();
        return data;
    } catch (error) {
        console.error('Erro:', error);
        throw error;
    }
};