import './Botao.css'
import { useNavigate } from "react-router-dom";

const Botao = ({label, destino, estado}) => {
    const navegador = useNavigate();

    const handleClick = () => {
        if (destino) {
            navegador(destino); // Redireciona para a página especificada
        }
        if (estado) {
            navegador(destino, { state: estado });
        } else {
            navegador(destino);  // Caso não haja estado, só navega para o destino
        }
    };

    return(
        <div className='container_botao'>
            <button onClick={handleClick}>{label}</button>
        </div>
    )
}

export default Botao;