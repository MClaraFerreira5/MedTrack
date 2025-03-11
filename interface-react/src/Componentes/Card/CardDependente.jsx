import { useState } from "react";
import { Phone, Trash, UserCircleIcon } from "lucide-react";
import { useNavigate } from "react-router-dom";

const CardDependente = ({ termoPesquisa, dependentes, removerDependente }) => {
    // const [dependentes, setDependentes] = useState([
    //     { id: 1, nome: "Maria Silva",  telefone: "(11) 98765-4321"},
    //     { id: 2, nome: "João Souza",  telefone: "(21) 98888-1111" },
    //     { id: 3, nome: "Ana Santos", telefone: "(31) 99999-2222" },
    //     { id: 4, nome: "Carimbo",  telefone: "(11) 98765-4321"},
    //     { id: 5, nome: "Beyonce",  telefone: "(81)98636-6767" },
    //     { id: 6, nome: "Jimbo", telefone: "(81)98636-6767"},
    //     { id: 7, nome: "James", telefone: "(81)98636-6767" }
    // ]);


    const navigate = useNavigate();

    const dependentesFiltrados = dependentes.filter(dep =>
        dep.nome.toLowerCase().includes(termoPesquisa.toLowerCase())
    );

    return (
        <div className="p-6">
            <div className="flex flex-wrap max-h-[500px] gap-5 justify-center overflow-y-auto p-2 border border-cyan-200 rounded-lg">
                {dependentesFiltrados.map((dep) => (
                    <div key={dep.id} className="bg-white shadow-lg rounded-xl p-5 border border-gray-200 flex flex-col items-center w-64">
                        <h3 className="text-xl font-semibold">{dep.nome}</h3>
                        <div className="flex items-center gap-2 text-gray-700 mt-2">
                            <Phone size={16} className="text-cyan-500" />
                            <span>{dep.telefone}</span>
                        </div>
                        <div className="flex gap-5">
                            <button 
                                onClick={() => removerDependente(dep.id)}
                                className="mt-4 bg-red-500 text-white px-3 py-1 rounded hover:bg-red-600"
                            >
                                <Trash size={16} />
                            </button>
                            <button
                                className="mt-4 bg-green-500 text-white px-3 py-1 rounded hover:bg-red-600"
                                onClick={() => navigate("/perfil") }
                            >
                                <UserCircleIcon size={16} />
                            </button>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default CardDependente;