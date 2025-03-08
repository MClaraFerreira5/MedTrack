import { useState } from 'react';
import FormularioCadastro from '../../Componentes/FormularioCadastro';

const CadastroDependente = () => {
  const [formData, setFormData] = useState({
    nome: "",
    numero: "",
    idade: ""
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  const camposCadastro = [
    { type: "text", id: "nome-completo", label: "Nome", name: "nome", placeholder: "Digite o nome do dependente" },
    { type: "number", id: "numero", label: "Número", name: "numero", placeholder: "Digite o número do dependente" },
    { type: "text", id: "email", label: "Email", name: "email", placeholder: "Digite o email do dependente" }
  ];

  const botaos = [{ label: "Criar", destino: "/lista_dependentes" }];

  return (
      <div className="h-screen flex justify-center items-center w-full text-center">
        <FormularioCadastro
            h1="Novo Dependente"
            campos={camposCadastro}
            botaos={botaos}
            formData={formData} // Agora passa o objeto completo
            handleChange={handleChange} // Passa a função que atualiza o estado
        />
      </div>
  );
};

export default CadastroDependente;