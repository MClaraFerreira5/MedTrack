import { useState } from "react";
import Header from "../../Componentes/Header/index.jsx";
import Sidebar from "../../Componentes/Sidebar/index.jsx";
import CardDependente from "../../Componentes/Card/CardDependente.jsx";
import Botao from "../../Componentes/Botao/index.jsx";

const ListaDependentes = () => {
   // const [modoPesquisa, setModoPesquisa] = useState(false);
    const [termoPesquisa, setTermoPesquisa] = useState("");

    const [dependentes, setDependentes] = useState([
        { id: 1, nome: "Maria Silva", idade: 10, telefone: "(11) 98765-4321", emDia: true },
        { id: 2, nome: "João Souza", idade: 15, telefone: "(21) 98888-1111", emDia: false },
    ]);

    const adicionarDependente = (novoDependente) => {
        setDependentes([...dependentes, novoDependente]);
    };

    const removerDependente = (id) => {
        setDependentes(dependentes.filter(dep => dep.id !== id));
    };
    return (
        <div className="flex flex-col h-screen">
            <div className="flex flex-1">
                <Sidebar className="w-64" type={true} />
                <div className="flex-1 p-4 transition-all duration-300">
                    <Header h1={"MedTrack"} exibirPesquisa={true} setTermoPesquisa={setTermoPesquisa} />
                    <div className="flex self-center justify-between mt-10 ml-10 mr-10">
                        <h1 className="text-2xl font-bold mt-2 ">Lista de Dependentes</h1>
                        <Botao label={"Criar novo dependente"} destino={"/cadastro_dependente"} />
                    </div>
                    <CardDependente termoPesquisa={termoPesquisa} dependentes={dependentes} removerDependente={removerDependente} />
                </div>
            </div>
        </div>
    );
};

export default ListaDependentes;