import { useState } from "react";
import FormularioCadastro from "../../Componentes/FormularioCadastro";
const PaginaCadastro2 = ({h1, p}) => {
    const [nomeUsuario, setNomeUsuario] = useState("");
    const [senha, setSenha] = useState("");
    const [confSenha, setConfSenha] = useState("");
    
    const camposCadastro = [
    { type: "text", id: "nome-usuario", label: "Nome de Usuário: ", name: "user", placeholder: "Digite seu nome de usuário", value: nomeUsuario, onChange: (e) => setNomeUsuario(e.target.value) },
    { type: "password", id: "senha", label: "Senha: ", name: "senha", placeholder: "Digite sua senha", value: senha, onChange: (e) => setSenha(e.target.value) },
    { type: "password", id: "confSenha", label: "Confirme sua senha: ", name: "confSenha", placeholder: "Confirme sua senha", value: confSenha, onChange: (e) => setConfSenha(e.target.value) }

    ]

    const botaos = [
        { label: "Voltar", destino: "/cadastro"},
        { label: "Finalizar", destino: "/cadastro_concluido"}
      ]
 return(
        <div className=" h-screen flex justify-center items-center w-full text-center">
            <FormularioCadastro h1={"Quase-lá"} p={"Agora cadastre seu usuário"} campos={camposCadastro} botaos={botaos} />
        </div>
        
    )
}

export default PaginaCadastro2