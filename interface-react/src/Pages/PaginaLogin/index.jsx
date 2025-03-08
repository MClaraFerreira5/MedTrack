// import { useState } from 'react';
// import FormularioCadastro from '../../Componentes/FormularioCadastro';
// import { useNavigate } from 'react-router-dom';
//
// const PaginaLogin = () => {
//     const [nomeUsuario, setNomeUsuario] = useState("");
//     const [senha, setSenha] = useState("");
//     const [erro, setErro] = useState(""); // Estado para armazenar mensagens de erro
//     const navigate = useNavigate();
//
//     const camposCadastro = [
//         { type: "text", id: "nome-usuario", label: "Nome de Usuário: ", name: "user", placeholder: "Digite seu nome de usuário", value: nomeUsuario, onChange: (e) => setNomeUsuario(e.target.value) },
//         { type: "password", id: "senha", label: "Senha: ", name: "senha", placeholder: "Digite sua senha", value: senha, onChange: (e) => setSenha(e.target.value) },
//     ];
//
//     const botaos = [
//         { label: "Entrar" }
//     ];
//
//     const handleLogin = async () => {
//         try {
//             const response = await fetch('http://localhost:8081/auth/login', {
//                 method: 'POST',
//                 headers: {
//                     'Content-Type': 'application/json',
//                 },
//                 body: JSON.stringify({
//                     username: nomeUsuario,
//                     password: senha,
//                 }),
//             });
//
//             alert(response)
//
//             if (response.ok) {
//                 const data = await response.json();
//                 const token = data; // O token JWT é retornado diretamente no corpo da resposta
//
//                 // Armazenar o token no localStorage
//                 localStorage.setItem('token', token);
//
//                 // Redirecionar para a página de dashboard
//                 navigate('/dashboard');
//             } else {
//                 // Tratar erros de autenticação
//                 setErro("Usuário ou senha inválidos.");
//             }
//         } catch (error) {
//             console.error("Erro ao fazer login:", error);
//             setErro("Erro ao conectar com o servidor.");
//         }
//     };
//
//     return (
//         <div className="h-screen flex justify-center items-center w-full text-center">
//             <FormularioCadastro
//                 h1={"Login"}
//                 campos={camposCadastro}
//                 botaos={botaos}
//                 onSubmit={handleLogin} // Adicionar onSubmit ao FormularioCadastro
//             />
//             {erro && <p className="text-red-500 mt-4">{erro}</p>} {/* Exibir mensagem de erro */}
//         </div>
//     );
// };
//
// export default PaginaLogin;

import { useState } from 'react';
import FormularioCadastro from '../../Componentes/FormularioCadastro';
import { useNavigate } from 'react-router-dom';

const PaginaLogin = () => {
    const [formData, setFormData] = useState({ username: "", password: "" }); // Estado para armazenar os dados do formulário
    const [erro, setErro] = useState(""); // Estado para armazenar mensagens de erro
    const navigate = useNavigate();

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };

    const camposCadastro = [
        { type: "text",
            id: "nome-usuario",
            label: "Nome de Usuário: ",
            name: "username",
            placeholder: "Digite seu nome de usuário",
            value: formData.username,
            onChange: (e) => {
                console.log("Digitando usuário:", e.target.value);
                setFormData({ ...formData, username: e.target.value });
            }
        },
        { type: "password",
            id: "senha",
            label: "Senha: ",
            name: "password",
            placeholder: "Digite sua senha",
            value: formData.password,
            onChange: (e) => {
                console.log("Digitando senha:", e.target.value);
                setFormData({ ...formData, password: e.target.value });
            }
        },
    ];

    const botaos = [
        { label: "Entrar" }
    ];

    const handleLogin = async (e) => {
        e.preventDefault(); // Impede o comportamento padrão do formulário

        console.log("Dados enviados:", formData); // Depuração

        try {
            const response = await fetch('http://localhost:8081/auth/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formData), // Usar formData no corpo da requisição
            });

            console.log("Resposta da API:", response); // Depuração

            if (response.ok) {
                const token = await response.text(); // Supondo que a resposta seja JSON
                console.log("Token recebido:", token); // Depuração

                // Armazenar o token no localStorage
                localStorage.setItem('token', token); // Supondo que o token esteja em data.token

                // Redirecionar para a página de dashboard
                navigate('/dashboard');
            } else {
                // Tratar erros de autenticação
                const errorText = await response.text(); // Ler a resposta como texto
                console.error("Erro do backend:", errorText); // Depuração

                // Exibir mensagem de erro para o usuário
                setErro(errorText || "Usuário ou senha inválidos.");
            }
        } catch (error) {
            console.error("Erro ao fazer login:", error);
            setErro("Erro ao conectar com o servidor. Verifique sua conexão ou tente novamente mais tarde.");
        }
    };

    return (
        <div className="h-screen flex justify-center items-center w-full text-center">
            <FormularioCadastro
                h1={"Login"}
                campos={camposCadastro}
                botaos={botaos}
                onSubmit={handleLogin}
                formData={formData} // Passamos os dados do formulário
                handleChange={handleChange}
                // Adicionar onSubmit ao FormularioCadastro
            />
            {erro && <p className="text-red-500 mt-4">{erro}</p>} {/* Exibir mensagem de erro */}
        </div>
    );
};

export default PaginaLogin;