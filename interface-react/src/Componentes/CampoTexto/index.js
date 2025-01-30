import { useState } from 'react'
import './CampoTexto.css'

const CampoTexto = (props) => {

    const placeholderModificada = `${props.placeholder}...`

    //let valor = 'Jesus'

    const [valor, setValor] = useState('')

    const aoDigitado = (evento) => {
        props.aoAlterado()
    }

    return(
        <div className="campo-texto"> 
            <label>{props.label}</label>
            <input placeholder={props.placeholderModificada}/>
        </div>
    )
}

export default CampoTexto