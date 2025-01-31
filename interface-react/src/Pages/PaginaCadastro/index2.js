import FormularioCadastro2 from "../../Componentes/FormularioCadastro/index2"
const PaginaCadastro2 = ({h1, p}) => {



    return(
        <div className="container_tela">
            <div className='container_cadastro'>
                <h1>{h1}</h1>
                <p>{p}</p>
                <FormularioCadastro2/>
            </div>
        </div>
    )
}

export default PaginaCadastro2