import './PaginaLogin.css'
import FormularioLogin from '../../Componentes/FormularioLogin'

const PaginaLogin = ({h1, p}) => {
    return(
        <div className="container_tela">
            <div className='container_cadastro'>
                <h1>{h1}</h1>
                <p>{p}</p>
                <FormularioLogin/>
            </div>
        </div>
    )
}

export default PaginaLogin