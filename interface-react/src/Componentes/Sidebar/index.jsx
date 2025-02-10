import { useState } from "react";
import { motion } from "framer-motion";
import { Menu, X } from "lucide-react";
import Perfil from "../Perfil";
import ListaFuncionalidades from "../ListaFuncionalidades";

export default function Sidebar({}) {
  const [expandida, setExpandida] = useState(false);

  return (
    <div className="relative" >
      {/* Botão de abrir/fechar */}
      <button
        onClick={() => setExpandida(!expandida)}
        className="p-3 bg-gray-800 text-white rounded-md fixed top-2 left-2 z-50"
      >
        {expandida ? <X /> : <Menu />}
      </button>

      {/* Sidebar animada */}
      <motion.div
        initial={{ x: -300 }}
        animate={{ x: expandida ? 0 : -300 }}
        transition={{ duration: 0.3 }}
        className="fixed left-0 top-0 h-full w-64 bg-gray-900 text-white p-5 shadow-lg"
      >
        <Perfil />
        <ListaFuncionalidades />
      </motion.div>
    </div>
  );
}
