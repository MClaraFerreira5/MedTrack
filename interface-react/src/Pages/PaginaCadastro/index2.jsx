import React, { useState } from 'react';
import FormularioCadastro from '../../Componentes/FormularioCadastro';
import { useLocation, useNavigate } from 'react-router-dom';
import { cadastrarUsuario } from '../../Service/cadastrarUsuario';

const PaginaCadastro2 = ({ h1, p }) => {
    const location = useLocation();
    console.log('Dados da primeira tela_2:', location.state);
    const navigate = useNavigate();

    const [formData, setFormData] = useState({
        nomeUsuario: '',
        senha: '',
        confSenha: '',
        tipoConta: ''
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleSubmit = async (e) => {
        console.log('Formulário submetido!');
        e.preventDefault();

        console.log('Dados do formulário:', formData);

        if (!formData.nomeUsuario || !formData.senha || !formData.confSenha || !formData.tipoConta) {
            alert('Por favor, preencha todos os campos.');
            return;
        }

        if (formData.senha !== formData.confSenha) {
            alert('As senhas não coincidem!');
            return;
        }

        if (formData.tipoConta === '') {
            alert('Por favor, selecione um tipo de conta.');
            return;
        }

        const dadosCadastro = {
            ...location.state, // Dados da primeira página
            nomeUsuario: formData.nomeUsuario,
            senha: formData.senha,
            tipoConta: formData.tipoConta
        };

        console.log('Dados enviados para a API:', dadosCadastro);

        try {
            const sucesso = await cadastrarUsuario(dadosCadastro);

            if (sucesso) {
                navigate('/cadastro_concluido');
            } else {
                alert('Erro ao cadastrar usuário. Tente novamente.');
            }
        } catch (error) {
            console.error('Erro ao cadastrar usuário:', error);
            alert('Erro ao cadastrar usuário. Verifique sua conexão ou tente novamente mais tarde.');
        }
    };

    const camposCadastro = [
        { type: 'text', id: 'nome-usuario', label: 'Nome de Usuário: ', name: 'nomeUsuario', placeholder: 'Digite seu nome de usuário' },
        { type: 'password', id: 'senha', label: 'Senha: ', name: 'senha', placeholder: 'Digite sua senha' },
        { type: 'password', id: 'confSenha', label: 'Confirme sua senha: ', name: 'confSenha', placeholder: 'Confirme sua senha' },
        {
            type: 'select', id: 'tipo-conta', label: 'Tipo de Conta:', name: 'categoria', options: [

                { value: '', text: 'Selecione...' },
                { value: 'ADMINISTRADOR', text: 'Administrador' },
                { value: 'PESSOAL', text: 'Pessoal' }
            ]
        }
    ];

    const botaos = [
        { label: 'Voltar', destino: '/cadastro' },
        { label: 'Finalizar', type: "submit" }
    ];

    return (
        <div className="h-screen flex justify-center items-center w-full text-center">
            <FormularioCadastro
                h1={'Quase-lá'}
                p={'precisamos de mais algumas informações'}
                campos={camposCadastro}
                botaos={botaos}
                login={true}
                onSubmit={handleSubmit}
                formData={formData}
                handleChange={handleChange}
            />
        </div>
    );
};

export default PaginaCadastro2;