import Botao from '../Botao'
import './Main.css'

const Main = () => {
    return(
        <div className="container_main">
            <section>
                <h1>Gerencie suas medicações com facilidade!</h1>
                <p>O MedTrack é uma plataforma que organiza suas
                     medicações e notifica você na hora certa. Mantenha sua saúde em dia com um sistema simples e eficiente.</p>
                <div className="container_main_botoes">
                    <Botao label= "Cadastre-se já" destino="/cadastro"/>
                    <Botao label= "Login"/>
                </div>
            </section>
            <section className="imagem_container">
                <img src=".\Imagens\img.png"></img>
            </section>
        </div>
    )
}

export default Main