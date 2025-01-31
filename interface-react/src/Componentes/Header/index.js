import './Header.css'
import Botao from '../Botao';
const Header = () => {
    return(
        <div className="container_header">
            <h1>MedTrack</h1>

            <nav>
                <a>Home</a>
                <a>Contato</a>
                <a>Sobre</a>
                <a>Blog</a>
                <Botao label="Sign-Up" destino='/cadastro'/>
            </nav>
        </div>
    )
}

export default Header