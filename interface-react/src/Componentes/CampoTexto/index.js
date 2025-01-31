import { useState } from 'react'
import './CampoTexto.css'

const CampoTexto = (props) => {

    const placeholderModificada = `${props.placeholder}...`

    const [valor, setValor] = useState('')

    const aoDigitado = (evento) => {
        setValor(evento.target.value)
        if (props.aoAlterado){
            props.aoAlterado(evento.target.value)
        }
        
    }

    return(
        <div className="campo-texto"> 
            <label>{props.label}</label>
            <input 
            placeholder={placeholderModificada} 
            type={props.type}/>
        </div>
    )
}

export default CampoTexto