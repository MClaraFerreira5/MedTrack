import { Link } from "react-router-dom";
import { ClipboardList, Box, Clock, Calendar, Home } from "lucide-react";

const ListaFuncionalidades = () => {
  return (
    <nav className="p-4 text-white">
      <ul className="space-y-4">
        <li>
          <Link to="/home" className="flex items-center gap-2 p-2 hover:bg-gray-700 rounded">
            <Home className="w-5 h-5" /> HOME
          </Link>
        </li>
        <li>
          <Link to="/lista_dependentes" className="flex items-center gap-2 p-2 hover:bg-gray-700 rounded">
            <ClipboardList className="w-5 h-5" /> LISTA DE DEPENDENTES
          </Link>
        </li>
        <li>
          <Link to="/estoque" className="flex items-center gap-2 p-2 hover:bg-gray-700 rounded">
            <Box className="w-5 h-5" /> RELATÓRIOS
          </Link>
        </li>
        <li>
          <Link to="/lembretes" className="flex items-center gap-2 p-2 hover:bg-gray-700 rounded">
            <Clock className="w-5 h-5" />CONFIGURAÇÕES
          </Link>
        </li>
        <li>
          <Link to="/consultas" className="flex items-center gap-2 p-2 hover:bg-gray-700 rounded">
            <Calendar className="w-5 h-5" /> LOGOUT
          </Link>
        </li>

      </ul>
    </nav>
  );
};

export default ListaFuncionalidades;