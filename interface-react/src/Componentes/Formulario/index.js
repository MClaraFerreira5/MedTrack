import Botao from '../Botao';
import CampoTexto from '../CampoTexto';
import './Formulario.css'

const Formulario = () => {
    return(
        <div className='container_formulario'>
            <h1>Coloque as Informações</h1> 
            <CampoTexto label="Nome" placeholder="Digite o nome do Remédio"/>
            <CampoTexto label="Nome do Agente Ativo"/>
            <CampoTexto label="Quantidade da Caixa"/>
            <CampoTexto label="Quantas vezes ao dia"/>
            <CampoTexto label="Quantos miligramas"/>
            <Botao></Botao>
        </div>
    )
}

export default Formulario;