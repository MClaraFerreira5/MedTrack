import CampoTexto from "../CampoTexto"
import './FormularioCadastro.css'
import Botao from "../Botao"

const FormularioCadastro = () => {
    return(
        <div className="container_formularioCadastro">
            <CampoTexto type="text" id="nome-completo" label="Nome:" name="fullName" placeholder="Digite seu nome completo"/>

            <CampoTexto type="email" label="E-mail:" placeholder="Digite seu e-mail"/>
            <CampoTexto label="Data de Nascimento:" type="date"/>
            <Botao label="Next" destino='/cadastro_user'></Botao>
        </div>
    )

}

export default FormularioCadastro