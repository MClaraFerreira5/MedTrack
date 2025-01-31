import './PaginaCadastro.css'
import CampoTexto from '../../Componentes/CampoTexto'
import FormularioCadastro from '../../Componentes/FormularioCadastro'

const PaginaCadastro = ({h1, p}) => {



    return(
        <div className="container_tela">
            <div className='container_cadastro'>
                <h1>{h1}</h1>
                <p>{p}</p>
                <FormularioCadastro/>
            </div>
        </div>
    )
}

export default PaginaCadastro