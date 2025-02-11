import { useState } from 'react';
import FormularioCadastro from '../../Componentes/FormularioCadastro';

const CadastroDependente = () => {
  const [nome, setNome] = useState("");
  const [numero, setNumero] = useState("");
  const [idade, setIdade] = useState("");

  const camposCadastro = [
    { type: "text", id: "nome-completo", label: "Nome", name: "nome", placeholder: "Digite seu nome", value: nome, onChange: (e) => setNome(e.target.value) },
    { type: "number", id: "numero", label: "Número", name: "numero", placeholder: "Digite seu número", value: numero, onChange: (e) => setNumero(e.target.value) },
    { type: "number", id: "idade", label: "Idade", name: "idade", placeholder: "Digite sua idade", value: idade, onChange: (e) => setIdade(e.target.value) }
  ];

  const botaos = [
    { label: "Criar", destino: "/lista_dependentes"}
  ]
  

  return (
    <div className=" h-screen flex justify-center items-center w-full text-center">
        <FormularioCadastro h1={"Novo Dependente"} campos={camposCadastro} botaos={botaos} />
      </div>
  );
};

export default CadastroDependente;
