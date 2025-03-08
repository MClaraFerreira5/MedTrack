import CampoTexto from "../CampoTexto";
import Botao from "../Botao";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

const FormularioCadastro = ({ campos, botaos, login, h1, p }) => {
  const [formData, setFormData] = useState(
    campos.reduce((acc, campo) => ({ ...acc, [campo.name]: "" }), {})
  );
  const navigate = useNavigate();

  // Atualiza o estado do input de forma dinâmica
  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const irPraProxima = () => {
    navigate("/cadastro_user", { state: formData });
  };

  return (
    <div className="flex flex-col sm:shadow-lg sm:shadow-cyan-500/50 sm:p-20 sm:w-3/5 w-full m-10">
        <h1 className="text-2xl font-semibold ">{h1}</h1>
        <p className="mt-4 ">{p}</p>
    <div className="flex flex-col my-2 gap-4 justify-between">
      {campos.map((campo) => 
      
      campo.type === "select" ? (
        <div key={campo.id} className="flex flex-col  ">
          <label className="text-left text-gray-700 font-medium" htmlFor={campo.id}>{campo.label}</label>
          <select id={campo.id} name={campo.name} value={campo.value} onChange={campo.onChange} className="border p-2 border-blue-400 rounded-lg">
            {campo.options.map(opt => (
              <option key={opt.value} value={opt.value}>{opt.text}</option>
            ))}
          </select>
        </div>
      ) :(
        <div>
        <CampoTexto
          key={campo.name}
          type={campo.type}
          id={campo.id}
          label={campo.label}
          name={campo.name}
          value={formData[campo.name]}
          placeholder={campo.placeholder}
          onChange={handleChange}
        />
        </div>
      ))}
      {login? (
          <a className="text-blue-500 hover:underline text-sm cursor-pointer" href="/login">
          Já possui uma conta? Faça o Login
        </a>
        ):(<div> <a className="text-blue-500 hover:underline text-sm cursor-pointer" href="/recuperacaosenha">
          Esqueceu a sua senha? Clique Aqui.
        </a></div>)}
        
</div>
      <div className="flex self-end">
        {botaos.map((prop) => (
          <Botao 
            label={prop.label}
            destino={prop.destino}
           />
        ))}

      </div>
    </div>
  );
};

export default FormularioCadastro;
