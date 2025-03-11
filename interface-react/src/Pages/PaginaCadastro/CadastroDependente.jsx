import { useState } from 'react';
import FormularioCadastro from '../../Componentes/FormularioCadastro';
import api from "../../Service/api";
import {cadastrarUsuario} from "../../Service/cadastrarUsuario";
import {useNavigate} from "react-router-dom";

const CadastroDependente = () => {
  const [formData, setFormData] = useState({
    nome: "",
    telefone: "",
    email: "",
    nomeUsuario:"",
    senha:""
  });

  const navigate = useNavigate()

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {
    console.log('Formulário do Dependente submetido ');
    e.preventDefault();


    console.log('Dados do formulário:', formData);

    if (!formData.nome || !formData.telefone|| !formData.email || !formData.nomeUsuario || !formData.senha) {
      alert('Por favor, preencha todos os campos.');
      return;
    }

    const dadosCadastro = {
      nome: formData.nome,
      telefone: formData.telefone,
      email: formData.email,
      nomeUsuario: formData.nomeUsuario,
      senha: formData.senha
    };



    setFormData({ nome: "", telefone: "", email: "" , nomeUsuario: "", senha: ""});

    try {
      const sucesso = await api.post("http://localhost:8081/dependentes/cadastrar", dadosCadastro);
      console.log("Dependente cadastrado com sucesso!");
      if (sucesso) {
        navigate('/lista_dependentes');
      } else {
        alert('Erro ao cadastrar usuário. Tente novamente.');
      }
    } catch (error) {
      console.error('Erro ao cadastrar usuário:', error);
      alert('Erro ao cadastrar usuário. Verifique sua conexão ou tente novamente mais tarde.');
    }
  };

  const camposCadastro = [
    { type: "text", id: "nome-completo", label: "Nome", name: "nome", placeholder: "Digite o nome do dependente" },
    { type: "number", id: "telefone", label: "Número", name: "telefone", placeholder: "Digite o número do dependente" },
    { type: "text", id: "email", label: "Email", name: "email", placeholder: "Digite o email do dependente" },
    { type: "user", id: "nomeUsuario", label: "Nome de Usuário:", name: "nomeUsuario", placeholder: "Digite o nome de Usuário"},
    { type: "password", id: "password", label: "Senha: ", name: "senha", placeholder: "Digite sua senha"}
  ];

  const botaos = [{ label: "Criar", type: "submit" }];

  return (
      <div className="h-screen flex justify-center items-center w-full text-center">
        <FormularioCadastro
            h1="Novo Dependente"
            campos={camposCadastro}
            botaos={botaos}
            formData={formData} // Agora passa o objeto completo
            handleChange={handleChange} // Passa a função que atualiza o estado
            onSubmit={handleSubmit}

        />
      </div>
  );
};

export default CadastroDependente;