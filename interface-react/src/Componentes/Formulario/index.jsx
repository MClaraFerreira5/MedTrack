import Botao from "../Botao";
import CampoTexto from "../CampoTexto";

const Formulario = () => {
  return (
    <div className="flex flex-col items-center justify-center min-h-screen px-4">
      <div className="bg-white shadow-md rounded-lg p-8 w-full max-w-md">
        <h1 className="text-2xl font-semibold text-center mb-6">
          Coloque as Informações
        </h1>

        <CampoTexto label="Nome" placeholder="Digite o nome do remédio" />
        <CampoTexto label="Nome do Agente Ativo" placeholder="Digite o agente ativo" />
        <CampoTexto label="Quantidade da Caixa" placeholder="Digite a quantidade" />
        <CampoTexto label="Quantas vezes ao dia" placeholder="Digite a frequência" />
        <CampoTexto label="Quantos miligramas" placeholder="Digite a dosagem" />

        <div className="flex justify-center mt-4">
          <Botao label="Enviar" />
        </div>
      </div>
    </div>
  );
};

export default Formulario;
