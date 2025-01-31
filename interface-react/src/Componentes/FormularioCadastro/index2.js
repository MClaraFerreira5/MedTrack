import CampoTexto from "../CampoTexto"
import './FormularioCadastro.css'
import Botao from "../Botao"

const FormularioCadastro2 = () => {
    return(
        <div className="container_formularioCadastro">
            <CampoTexto type="user"  label="Nome de Usuário:"  placeholder="Digite seu nome de usuário"/>
            <CampoTexto type="password" label="Senha:" placeholder="Digite sua senha"/>
            <CampoTexto type="password" label="Confirme sua senha" placeholder="Confirme sua senha"/>
            <div className="botoes">
                <Botao label='Voltar' destino='/cadastro'/>
                <Botao type= "Submit" label="Criar conta"></Botao>
            </div>
        </div>
    )}

export default FormularioCadastro2