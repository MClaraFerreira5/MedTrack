import Botao from '../Botao';

const Main = () => {
  return (
    <div className="flex justify-center items-center w-4/5 mx-auto ">
      <section className="mt-24 w-1/2">
        <h1 className="text-3xl">Gerencie suas medicações com facilidade!</h1>
        <p className="mt-4">O MedTrack é uma plataforma que organiza suas medicações e notifica você na hora certa. Mantenha sua saúde em dia com um sistema simples e eficiente.</p>
        <div className="flex gap-8 mt-6">
          <Botao label="Sign-Up" destino="/cadastro" />
          <Botao label="Login" destino="/login" />
        </div>
      </section>
      <section className="hidden sm:block w-1/2">
        
      </section>
    </div>
  );
};

export default Main;
