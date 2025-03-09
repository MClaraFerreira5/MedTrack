import { Profiler, useState } from "react";
import { Phone, Trash, UserCircleIcon } from "lucide-react"; // Ícones para telefone e remoção
import { useNavigate } from "react-router-dom";
const CardDependente = () => {
  const [dependentes, setDependentes] = useState([
    { id: 1, nome: "Maria Silva", idade: 10, telefone: "(11) 98765-4321" },
    { id: 2, nome: "João Souza", idade: 15, telefone: "(21) 98888-1111" },
    { id: 3, nome: "Ana Santos", idade: 65, telefone: "(31) 99999-2222" },
    { id: 4, nome: "Carimbo", idade: 500.9, telefone: "(11) 98765-4321"},
    { id: 5, nome: "Beyonce", idade: 90, telefone: "(81)98636-6767" },
    { id: 6, nome: "Jimbo", idade: 90, telefone: "(81)98636-6767" },
    { id: 7, nome: "James", idade: 90, telefone: "(81)98636-6767" }

  ]);

  const removerDependente = (id) => {
    setDependentes(dependentes.filter(dep => dep.id !== id));
  };

  const navigate = useNavigate();

  return (
    <div className="p-6">
      
      <div className="flex flex-wrap max-h-[500px] gap-5 justify-center overflow-y-auto p-2 border border-cyan-200 rounded-lg">
        {dependentes.map((dep) => (
          <div key={dep.id} className="bg-white shadow-lg rounded-xl p-5 border border-gray-200 flex flex-col items-center w-64">
            <h3 className="text-xl font-semibold">{dep.nome}</h3>
            <p className="text-gray-600">Idade: {dep.idade} anos</p>
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
              className="mt-4 bg-green-500 text-white px-3 py-1 rounded hover:bg-red-600">
                <UserCircleIcon size={16}
                onClick={() => navigate("/perfil") }/>
            </button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default CardDependente;
