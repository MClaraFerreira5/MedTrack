import { useState } from "react";
import FormularioLogin from "../../Componentes/FormularioLogin";
import Botao from "../../Componentes/Botao";
import useMedicamentos from "../../Componentes/ListaDeMed";

const CadastroMedicamentos = () => {
    const [nomeMed, setNomeMed] = useState("");
    const [agenteAtivo, setAgenteAtivo] = useState("");
    const [quantidade, setQuantidade] = useState("");
    const [quantMili, setQuantMili] = useState("");
    const [quantDia, setQuantDia] = useState("");

    const { buscarAgenteAtivo, filtrarMedicamentos } = useMedicamentos();

    const handleNomeChange = (e) => {
        const nome = e.target.value;
        setNomeMed(nome);

        const agente = buscarAgenteAtivo(nome);
        setAgenteAtivo(agente);
    };

    return (
        <div className="flex flex-col items-center justify-center min-h-screen">
            <h1 className="text-2xl font-semibold text-center">Cadastro de Medicamentos</h1>

            <div className="flex flex-col my-2 p-10 gap-4 justify-between w-[400px]">
                <label htmlFor="nome-medicamento">Nome do Medicamento:</label>
                <input
                    type="text"
                    id="nome-medicamento"
                    list="sugestoes-medicamentos"
                    value={nomeMed}
                    onChange={handleNomeChange}
                    placeholder="Digite o nome do medicamento"
                    className="border p-2 rounded"
                />
                <datalist id="sugestoes-medicamentos">
                    {filtrarMedicamentos(nomeMed).map((med, index) => (
                        <option key={index} value={med} />
                    ))}
                </datalist>

                <label htmlFor="agente-ativo">Agente Ativo:</label>
                <input
                    type="text"
                    id="agente-ativo"
                    value={agenteAtivo}
                    onChange={(e) => setAgenteAtivo(e.target.value)}
                    placeholder="Agente ativo"
                    className="border p-2 rounded"
                />

                <label htmlFor="quantidade">Quantidade:</label>
                <input
                    type="number"
                    id="quantidade"
                    value={quantidade}
                    onChange={(e) => setQuantidade(e.target.value)}
                    placeholder="Digite a quantidade"
                    className="border p-2 rounded"
                />

                <label htmlFor="quant-mili">Quantos Miligramas?</label>
                <input
                    type="number"
                    id="quant-mili"
                    value={quantMili}
                    onChange={(e) => setQuantMili(e.target.value)}
                    placeholder="Digite quantos mg"
                    className="border p-2 rounded"
                />
            </div>

            <Botao label={"Salvar"} destino={"/perfil"} />
        </div>
    );
};

export default CadastroMedicamentos;
