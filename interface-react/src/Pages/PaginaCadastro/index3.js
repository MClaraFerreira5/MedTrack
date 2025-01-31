import './PaginaCadastro.css'
import CampoTexto from '../../Componentes/CampoTexto'
import FormularioCadastro from '../../Componentes/FormularioCadastro'
import Botao from '../../Componentes/Botao'
const PaginaCadastro3 = ({h1}) => {
    return(
        <div className="container_tela">
            <div className='container_cadastro'>
                <h1>{h1}</h1>
                <Botao 
                    label='Ir para a página principal'></Botao>
            </div>
        </div>
    )
}

export default PaginaCadastro3