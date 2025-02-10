import CampoTexto from "../CampoTexto";
import Botao from "../Botao";
import { useState } from "react";

const FormularioLogin = () => {
  const [usuario, setUsuario] = useState("");
  const [senha, setSenha] = useState("");

  return (
    <div className="flex flex-col items-center justify-center min-h-screen">
      <form className="bg-white shadow-md rounded-lg p-8 w-full max-w-md">
        <h2 className="text-2xl font-semibold text-center mb-6">Login</h2>

        <CampoTexto
          type="text"
          label="Nome de Usuário:"
          placeholder="Digite seu nome de usuário"
          value={usuario}
          onChange={(e) => setUsuario(e.target.value)}
        />

        <CampoTexto
          type="password"
          label="Senha:"
          placeholder="Digite sua senha"
          value={senha}
          onChange={(e) => setSenha(e.target.value)}
        />

        <div className="flex justify-center mt-4">
          <Botao label="Entrar" destino="/cadastro_user" />
        </div>
      </form>
    </div>
  );
};

export default FormularioLogin;
