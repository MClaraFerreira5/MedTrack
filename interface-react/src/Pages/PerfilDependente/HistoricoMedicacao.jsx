import RelatorioMedicacao from "../../Componentes/HistoricoMedicacoes";

const PaginaHistoricoDependentes = () => {
    const dados = {
        paciente: "João da Silva",
        semana: "04/03/2025 - 10/03/2025",
        observacoes: "Nenhuma observação relevante.",
        registros: [
          { data: "04/03/2025", remedio: "Paracetamol", horario: "08:00", dose: "500mg", tomado: true, observacoes: "Sem sintomas" },
          { data: "04/03/2025", remedio: "Omeprazol", horario: "07:00", dose: "20mg", tomado: false, observacoes: "Esqueci" },
          { data: "05/03/2025", remedio: "Paracetamol", horario: "08:00", dose: "500mg", tomado: true, observacoes: "Dor de cabeça leve" },
          { data: "06/03/2025", remedio: "Omeprazol", horario: "07:00", dose: "20mg", tomado: true, observacoes: "Melhorando" }
        ]
      };
    return(
        <RelatorioMedicacao dados={dados}/>
    )

}
export default PaginaHistoricoDependentes;