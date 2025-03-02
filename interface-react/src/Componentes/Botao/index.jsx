import { useNavigate } from "react-router-dom";

const Botao = ({ label, destino, estado }) => {
    const navegador = useNavigate();

    const handleClick = () => {
        if (destino) {
            navegador(destino, estado ? { state: estado } : undefined);
        }
    };

    return (
        <div className="flex justify-center">
            <button 
                onClick={handleClick} 
                className="bg-turquoise text-white px-6 py-2 rounded-full border-none"
            >
                {label}
            </button>
        </div>
    );
};

export default Botao;
