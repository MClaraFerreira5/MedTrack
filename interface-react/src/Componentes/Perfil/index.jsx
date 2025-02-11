import perfil from '../../Imagens/perfil.png';
import Box from '../Box';

const Perfil = ({vaiTer}) => {
  const camposCadastro = [
    { nome: "Nome Completo" },
    { nome: "Idade"},
    { nome: "Celular"},
    { nome: "Extra"}
  ]

  return (
    <div className="flex flex-col items-center w-full p-2">
      <img src={perfil} alt="Imagem de Perfil" className="w-24" />
      <h1 className="mt-2">Usuário</h1>
      <p className="mt-1">user@gmail.com</p>

      {vaiTer? (
        <div className='text-center mt-10'>
          <Box info={camposCadastro}/>
        </div>
      ):(<div></div>) }
    </div>
  );
};

export default Perfil;
