import CampoTexto from "../CampoTexto"
import './FormularioCadastro.css'
import Botao from "../Botao"
import { useState } from 'react';
import React from 'react';
import { useLocation } from 'react-router-dom';


const FormularioCadastro2 = () => {
    const [usuario, setUsuario] = useState('')
    const [senha, setSenha] = useState('')
    const [confSenha, setConfSenha] = useState('')
    const [nome, setNome] = useState('')
    const [email, setEmail] = useState('')
    const [data, setData] = useState('')
    
    const lidandoComSubmissao = (evento) => {
        evento.preventDefault();
        console.log("Nome:", nome);
        console.log("E-mail:", email);
        console.log("Data de Nascimento:", data);
        console.log(usuario)
        console.log(confSenha)
    }
            

    return(
        
        <div className="container_formularioCadastro">
            <form onSubmit={lidandoComSubmissao}>
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

                <CampoTexto 
                    type="password" 
                    label="Confirme sua senha" 
                    placeholder="Confirme sua senha"
                    value={confSenha}
                    onChange={(e) => setConfSenha(e.target.value)}/>

                <div className="botoes">
                    <Botao label='Voltar' destino='/cadastro'/>
                    <Botao type ="submit"label="Criar conta" destino='/cadastro_concluido'/>
                </div>
            </form>
        </div>
    )}

export default FormularioCadastro2