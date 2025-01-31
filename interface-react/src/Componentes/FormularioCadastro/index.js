import CampoTexto from "../CampoTexto"
import './FormularioCadastro.css'
import Botao from "../Botao"
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const FormularioCadastro = () => {
    const [nome, setNome] = useState('');
    const [email, setEmail] = useState('');
    const [data, setData] = useState('');
    const navigate = useNavigate();

    const handleChange = (e, setState) => {
        setState(e.target.value);
    };

    const irPraProxima = () => {
        navigate('/cadastro_user', {state: {nome, email, data}})
    }

    return(
        <div className="container_formularioCadastro">
            <CampoTexto 
                type="text" 
                id="nome-completo" 
                label="Nome:" 
                name="fullName" 
                value={nome}
                placeholder="Digite seu nome completo"
                onChange={(e) => handleChange(e, setNome)}/>

            <CampoTexto 
                type="email" 
                label="E-mail:" 
                placeholder="Digite seu e-mail"
                value={email}
                onChange={(e) => handleChange(e, setEmail)}/>

            <CampoTexto 
                label="Data de Nascimento:" 
                type="date"
                value={data} 
                onChange={(e) => handleChange(e, setData)} />
            
            <a>Já possui uma conta? Faça o Login</a>
            <Botao 
                label="Next"  
                estado={{nome, email, data}} 
                destino='/cadastro_user'></Botao>
        </div>
    )

}

export default FormularioCadastro