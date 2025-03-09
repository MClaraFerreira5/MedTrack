import { Profiler, useState } from "react";
import { Check, X } from "lucide-react"; // Ícones para telefone e remoção
import { useNavigate } from "react-router-dom";



const Relatorio = () => {
  const [dependentes, setDependentes] = useState([
    { id: 1, nome: "Maria Silva", idade: 10, telefone: "(11) 98765-4321", emDia: true },
    { id: 2, nome: "João Souza", idade: 15, telefone: "(21) 98888-1111", emDia: false },
    { id: 3, nome: "Ana Santos", idade: 65, telefone: "(31) 99999-2222", emDia: true },
    { id: 4, nome: "Carimbo", idade: 500.9, telefone: "(11) 98765-4321", emDia: true},
    { id: 5, nome: "Beyonce", idade: 90, telefone: "(81)98636-6767", emDia: false },
    { id: 6, nome: "Jimbo", idade: 90, telefone: "(81)98636-6767", emDia: true },
    { id: 7, nome: "James", idade: 90, telefone: "(81)98636-6767", emDia: true },
    { id: 8, nome: "Beyonce", idade: 90, telefone: "(81)98636-6767", emDia: true },
    { id: 9, nome: "Jimbo", idade: 90, telefone: "(81)98636-6767", emDia: true },
    { id: 10, nome: "James", idade: 90, telefone: "(81)98636-6767", emDia: true }

  ]);

  const navigate = useNavigate();

  return (
    <div className="p-6">
      
      <div className="mt:flex flex-col max-h-[450px] gap-9 justify-center overflow-y-auto p-2 border border-cyan-200 rounded-lg">
        <button className=" w-full"
                onClick={() => navigate("/historico_medicacoes")}>
        {dependentes.map((dep) => (
          <div key={dep.id} className=" flex justify-between bg-white  p-5 border border-gray-300  items-center w-full">
            <h1>{dep.nome}</h1>
            {dep.emDia? (<Check color="green"/>):(<X color="red"/>)}
          </div>
        ))}
        </button>
      </div>
    </div>
  );
};

export default Relatorio;