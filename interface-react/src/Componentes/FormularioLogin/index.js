import CampoTexto from "../CampoTexto"
import '../FormularioCadastro/FormularioCadastro.css'
import Botao from "../Botao"
import { useState } from "react"

const FormularioLogin = () => {
        const [usuario, setUsuario] = useState('')
        const [senha, setSenha] = useState('')
    return(
        <div className="container_formularioCadastro">
            <form>
            <CampoTexto 
                    type="text"  
                    label="Nome de Usuário:"  
                    placeholder="Digite seu nome de usuário"
                    value={usuario}
                    onChange={(e) => setUsuario(e.target.value)}/>

            <CampoTexto 
                type="password" 
                label="Senha:" 
                placeholder="Digite sua senha"
                value={senha}
                onChange={(e) => setSenha(e.target.value)}/>

            <Botao 
                label="Next"  
                destino='/cadastro_user'></Botao>
                </form>
        </div>
    )

}

export default FormularioLogin