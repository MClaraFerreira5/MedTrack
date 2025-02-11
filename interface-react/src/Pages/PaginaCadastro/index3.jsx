import CampoTexto from '../../Componentes/CampoTexto'
import FormularioCadastro from '../../Componentes/FormularioCadastro'
import Botao from '../../Componentes/Botao'
const PaginaCadastro3 = ({h1}) => {
    
    return(
        <div className="bg-teal-100 h-screen flex justify-center items-center w-full">
            <div className="bg-white p-12 text-center w-1/2">
                <h1 className="text-2xl font-semibold">{h1}</h1>
                <Botao 
                    label='Ir para a página principal'
                    destino='/dashboard'></Botao>
            </div>
        </div>
    )
}

export default PaginaCadastro3