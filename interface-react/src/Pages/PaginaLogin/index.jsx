
import FormularioLogin from '../../Componentes/FormularioLogin'
import fundoVerde from '../../Imagens/fundo_verde.jpeg';

const PaginaLogin = ({h1, p}) => {
    return(
        <div className="container_tela">
            <img src={fundoVerde}></img>
            <div className='container_cadastro'>
                <h1>{h1}</h1>
                <p>{p}</p>
                <FormularioLogin/>
            </div>
        </div>
    )
}

export default PaginaLogin