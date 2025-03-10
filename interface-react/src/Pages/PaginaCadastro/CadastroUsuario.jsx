import { useState } from "react";
import { Routes, Route } from "react-router-dom";
import PaginaCadastro from "../PaginaCadastro";
import PaginaCadastro2 from "../PaginaCadastro/index2.jsx";

const Cadastro = () => {
    const [formData, setFormData] = useState({
        nome: "",
        email: "",
        data: "",
        numero: "",
        nomeUsuario: "",
        senha: "",
        confSenha: "",
        tipoConta: "",
    });

    const updateFormData = (newData) => {
        setFormData((prev) => ({ ...prev, ...newData }));
    };

    return (
        <Routes>
            <Route
                path="/cadastro"
                element={<PaginaCadastro formData={formData} updateFormData={updateFormData} />}
            />
            <Route
                path="/cadastro_user"
                element={<PaginaCadastro2 formData={formData} updateFormData={updateFormData} />}
            />
        </Routes>
    );
};

export default Cadastro;