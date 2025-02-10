import Botao from '../Botao/index.jsx';

const Header = () => {
  return (
    <header className="flex justify-between items-center w-4/5 mx-auto py-4 ">
      <h1 className="text-2xl font-bold text-cyan-500">MedTrack</h1>
      
      <div className="flex items-center gap-6 ml-auto">
        <nav className="hidden md:flex gap-6 text-gray-700">
          <a href="#" className="hover:text-cyan-500">Home</a>
          <a href="#" className="hover:text-cyan-500">Contato</a>
          <a href="#" className="hover:text-cyan-500">Sobre</a>
          <a href="#" className="hover:text-cyan-500">Blog</a>
        </nav>

        <Botao label="Sign-Up" destino="/cadastro" />
      </div>
    </header>
  );
};

export default Header;
