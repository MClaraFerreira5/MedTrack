import CampoTexto from '../../Componentes/CampoTexto';
import FormularioCadastro from '../../Componentes/FormularioCadastro';

const PaginaCadastro = ({ h1, p }) => {
  return (
    <div className="bg-teal-100 h-screen flex justify-center items-center w-full">
      <div className="bg-white p-12 text-center w-1/2">
        <h1 className="text-2xl font-semibold">{h1}</h1>
        <p className="mt-4">{p}</p>
        <FormularioCadastro />
      </div>
    </div>
  );
};

export default PaginaCadastro;
