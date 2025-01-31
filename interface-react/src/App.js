import './App.css';
import { Routes, Route } from "react-router-dom";
import PaginaCadastro from './Pages/PaginaCadastro/index.js';
import PaginaPrincipal from './Pages/PaginaPrincipal/index.js';
import PaginaCadastro2 from './Pages/PaginaCadastro/index2.js';

function App() {
  return (
    
      <Routes>
        <Route path='/' element={<PaginaPrincipal/>}/>
        <Route path='/cadastro' element={<PaginaCadastro h1='Bem-Vindo ao MedTrack' p='Cadastre-se e comece a gerenciar suas medicações.'/>}/>
        <Route path='/cadastro_user' element={<PaginaCadastro2 h1='Quase lá' p='Agora cadastre seu nome de usuário e senha.'/>}/>
      </Routes>
    
  );
}

export default App;
