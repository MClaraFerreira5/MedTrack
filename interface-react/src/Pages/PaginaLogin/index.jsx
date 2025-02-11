import { useState } from 'react';
import FormularioCadastro from '../../Componentes/FormularioCadastro';
import FormularioLogin from '../../Componentes/FormularioLogin'
import fundoVerde from '../../Imagens/fundo_verde.jpeg';

const PaginaLogin = () => {
    const [nomeUsuario, setNomeUsuario] = useState("");
    const [senha, setSenha] = useState("");
    
    const camposCadastro = [
    { type: "text", id: "nome-usuario", label: "Nome de Usuário: ", name: "user", placeholder: "Digite seu nome de usuário", value: nomeUsuario, onChange: (e) => setNomeUsuario(e.target.value) },
    { type: "password", id: "senha", label: "Senha: ", name: "senha", placeholder: "Digite sua senha", value: senha, onChange: (e) => setSenha(e.target.value) },
    ]

    const botaos = [
      { label: "Entrar", destino:"/dashboard"}
    ]

    return(
        <div className=" h-screen flex justify-center items-center w-full text-center">
          
          <FormularioCadastro h1={"Login"}  campos={camposCadastro} botaos={botaos}/>
        </div>
     
    )
}

export default PaginaLogin