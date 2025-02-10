import perfil from '../../Imagens/perfil.png';

const Perfil = () => {
  return (
    <div className="flex flex-col items-center w-full p-5">
      <img src={perfil} alt="Imagem de Perfil" className="w-24" />
      <h1 className="mt-2">Usuário</h1>
      <p className="mt-1">user@gmail.com</p>
    </div>
  );
};

export default Perfil;
