import React, { useState } from 'react';
import FormularioCadastro from '../../Componentes/FormularioCadastro';
import { useNavigate } from 'react-router-dom';

const PaginaCadastro = ({ h1, p }) => {
  const [formData, setFormData] = useState({
    nome: "",
    email: "",
    data: ""
  });

  const navigate = useNavigate();

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const camposCadastro = [
    { type: "text", id: "nome-completo", label: "Nome: ", name: "nome", placeholder: "Digite seu nome" },
    { type: "email", id: "email", label: "E-mail: ", name: "email", placeholder: "Digite seu E-mail" },
    { type: "text", id: "numeroTelefone", label: "Número de Celular: ", name: "numeroTelefone", placeholder: "Digite seu Celular: " },
    { type: "date", id: "data", label: "Data de Nascimento: ", name: "dataNascimento", placeholder: "Digite sua idade" }
  ];

  const botaos = [
    { label: "Next", destino: "/cadastro_user" }
  ];

  const handleSubmit = (e) => {
    e.preventDefault();
    navigate('/cadastro_user', { state: formData });
    console.log("Dados da primeira tela_1:", formData)
  };

  return (
      <div className="h-screen flex justify-center items-center w-full text-center">
        <FormularioCadastro
            h1={"Bem-Vindo ao MedTrack"}
            p={"Cadastre-se e começe a gerenciar suas medicações."}
            campos={camposCadastro}
            botaos={botaos}
            login={true}
            formData={formData}
            handleChange={handleChange}
            onSubmit={handleSubmit}
        />
      </div>
  );
};

export default PaginaCadastro;