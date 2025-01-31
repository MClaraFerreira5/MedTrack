import './Botao.css'
import { useNavigate } from "react-router-dom";

const Botao = ({label, destino}) => {
    const navegador = useNavigate();

    const handleClick = () => {
        if (destino) {
            navegador(destino); // Redireciona para a página especificada
        }
    };

    return(
        <div className='container_botao'>
            <button onClick={handleClick}>{label}</button>
        </div>
    )
}

export default Botao;