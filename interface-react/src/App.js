import { Routes, Route } from "react-router-dom";
import PaginaCadastro from './Pages/PaginaCadastro/index.jsx';
import PaginaPrincipal from './Pages/PaginaPrincipal/index.jsx';
import PaginaCadastro2 from './Pages/PaginaCadastro/index2.jsx';
import PaginaCadastro3 from './Pages/PaginaCadastro/index3.jsx';
import PaginaLogin from './Pages/PaginaLogin/index.jsx';
import Dashboard from './Pages/Dashboard/index.jsx';
import ListaDependentes from "./Pages/Dashboard/ListaDependentes.jsx";
import './index.css'

function App() {
  return (
    
      <Routes>
        <Route path='/home' element={<PaginaPrincipal/>}/>
        <Route path='/login' element={<PaginaLogin h1="Login"/>}/>
        <Route path='/cadastro' element={<PaginaCadastro h1='Bem-Vindo ao MedTrack' p='Cadastre-se e comece a gerenciar suas medicações.'/>}/>
        <Route path='/cadastro_user' element={<PaginaCadastro2 />}/>
        <Route path='/cadastro_concluido' element={<PaginaCadastro3 h1="Usuário Cadastrado com sucesso!"/>}/>
        <Route path='/dashboard' element ={<Dashboard/>}/>
        <Route path="/lista_dependentes" element={<ListaDependentes/>}/>

      </Routes>
    
  );
}

export default App;
