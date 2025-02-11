import CampoTexto from "../CampoTexto";
import Botao from "../Botao";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

const FormularioCadastro = ({ campos, botaos }) => {
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
    <div className="flex flex-col gap-3">
      {campos.map((campo) => (
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
      ))}

      <div className="flex justify-between self-end px-5">
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
