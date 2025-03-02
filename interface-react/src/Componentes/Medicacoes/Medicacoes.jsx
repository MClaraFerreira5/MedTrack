import BoxMedicacao from "../BoxMedicacao";
import Botao from "../Botao"
const Medicacoes = () => {
    const medicamentos = [
        { nome: "Medicamento 1", quantidade: "2 comprimidos" },
        { nome: "Medicamento 2", quantidade: "1 cápsula" }
    ];

    return (
        <div className="flex flex-col gap-3 w-full h-screen border border-cyan-300 rounded-lg p-10">
            <div className="flex justify-between"> 
                <h2 className="text-2xl font-bold ">Lista de Medicações</h2>
                <Botao label={"Novo Medicamento"} destino={"/cadastro_medicamento"}/>
            </div>
            <BoxMedicacao props={medicamentos}  />
        </div>
    );
};

export default Medicacoes;
