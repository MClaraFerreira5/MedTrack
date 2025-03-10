import CampoTexto from "../CampoTexto";
import Botao from "../Botao";
import { useNavigate } from "react-router-dom";

const FormularioCadastro = ({ campos, botaos, h1, p, onSubmit, formData, handleChange, login }) => {
    const navigate = useNavigate();
    return (

        <div className="flex flex-col sm:shadow-lg sm:shadow-cyan-500/50 sm:p-20 sm:w-3/5 w-full m-10">
            <h1 className="text-2xl font-semibold">{h1}</h1>
            <p className="mt-4">{p}</p>
            <form onSubmit={onSubmit}>
                <div className="flex flex-col my-2 gap-4 justify-between">
                    {campos.map((campo) => (

                        <div key={campo.name}>
                            {campo.type === "select" ? (
                                <div key={campo.id} className="flex flex-col">
                                    <label className="text-left text-gray-700 font-medium" htmlFor={campo.id}>{campo.label}</label>
                                    <select
                                        id={campo.id}
                                        name={campo.name}
                                        value={formData[campo.name] || ""}
                                        onChange={handleChange}
                                        className="border p-2 border-blue-400 rounded-lg">

                                        {campo.options.map(opt => (
                                            <option key={opt.value} value={opt.value}>{opt.text}</option>
                                        ))}
                                    </select>
                                </div>
                            ) : (
                                <CampoTexto
                                    type={campo.type}
                                    id={campo.id}
                                    label={campo.label}
                                    name={campo.name}
                                    value={formData?.[campo.name] || ""} // Usa o estado do pai
                                    placeholder={campo.placeholder}
                                    onChange={handleChange} // Usa a função do pai
                                />
                            )}
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
                    {botaos.map((prop, index) => (
                        <Botao
                            key={index}
                            type={prop.type || "button"}
                            label={prop.label}
                            destino={prop.destino}
                        />
                    ))}
                </div>
            </form>
        </div>
    );
};

export default FormularioCadastro;
