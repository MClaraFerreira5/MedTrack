import { useState } from 'react'
import './CampoTexto.css'

const CampoTexto = ({ type, label, placeholder, value, onChange,}) => {


    const [valor, setValor] = useState('')



    return(
        <div className="campo-texto"> 
            <label>{label}</label>
            <input 
                placeholder={placeholder} 
                type={type}
                value={value} // Aqui você associa o valor do input ao estado
                onChange={onChange}/>
        </div>
    )
}

export default CampoTexto