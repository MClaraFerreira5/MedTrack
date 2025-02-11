import BoxMedicacao from "../BoxMedicacao";

const Medicacoes = () => {
    const medicamentos = [
        { nome: "Medicamento 1", quantidade: "2 comprimidos" },
        { nome: "Medicamento 2", quantidade: "1 cápsula" }
    ];

    return (
        <div className="flex flex-col gap-3 w-full h-screen border border-cyan-300 rounded-lg p-10">
            <h2 className="text-2xl font-bold ">Lista de Medicações</h2>
            <BoxMedicacao props={medicamentos} />
        </div>
    );
};

export default Medicacoes;
