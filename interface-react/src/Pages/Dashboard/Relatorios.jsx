import { useState } from "react";
import Header from "../../Componentes/Header/index.jsx";
import Sidebar from "../../Componentes/Sidebar/index.jsx";
import CardDependente from "../../Componentes/Card/CardDependente.jsx";
import Botao from "../../Componentes/Botao/index.jsx";
import Relatorio from "../../Componentes/Relatorio/index.jsx";

const Relatorios = () =>{
    const [modoPesquisa, setModoPesquisa] = useState(false);
    
    return(
    <div className="flex flex-col h-screen">
        <div className="flex flex-1">
            <Sidebar className="w-64"/>
        
        <div className="flex-1 p-4 transition-all duration-300">
            <Header h1={"MedTrack"} exibirPesquisa={true}/>
        <div className="flex self-center justify-between mt-10 ml-10 mr-10">
            <h1 className="text-2xl font-bold mt-2 ">Relatório dos Dependentes</h1>
            
        </div>
            <Relatorio/>
        </div>
    </div>
    </div>
    )
}

export default Relatorios;