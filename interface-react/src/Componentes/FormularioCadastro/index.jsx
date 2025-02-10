import CampoTexto from "../CampoTexto";
import Botao from "../Botao";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

const FormularioCadastro = () => {
  const [nome, setNome] = useState("");
  const [email, setEmail] = useState("");
  const [data, setData] = useState("");
  const navigate = useNavigate();

  const handleChange = (e, setState) => {
    setState(e.target.value);
  };

  const irPraProxima = () => {
    navigate("/cadastro_user", { state: { nome, email, data } });
  };

  return (
    <div className="flex flex-col gap-3">
      <CampoTexto
        type="text"
        id="nome-completo"
        label="Nome:"
        name="fullName"
        value={nome}
        placeholder="Digite seu nome completo"
        onChange={(e) => handleChange(e, setNome)}
      />

      <CampoTexto
        type="email"
        label="E-mail:"
        placeholder="Digite seu e-mail"
        value={email}
        onChange={(e) => handleChange(e, setEmail)}
      />

      <CampoTexto
        label="Data de Nascimento:"
        type="date"
        value={data}
        onChange={(e) => handleChange(e, setData)}
      />

      <a className="text-blue-500 hover:underline text-sm cursor-pointer" href="/login">
        Já possui uma conta? Faça o Login
      </a>

      <div className="flex justify-between px-5">
        <Botao label="Next" estado={{ nome, email, data }} destino="/cadastro_user" />
      </div>
    </div>
  );
};

export default FormularioCadastro;
