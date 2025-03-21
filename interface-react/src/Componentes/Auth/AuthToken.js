import { jwtDecode } from "jwt-decode";


export const isAuthenticated = () => {
    const token = localStorage.getItem("token");
    return !!token && !isTokenExpired(token); // Verifica se o token está presente e se não expirou
};


const isTokenExpired = (token) => {
    try {
        const decoded = jwtDecode(token);
        const currentTime = Date.now() / 1000;
        const expirationTime = decoded.exp;
        return expirationTime < currentTime;
    } catch (error) {
        console.error("Erro ao verificar a expiração do token:", error);
        return true; // Se houver erro, assume-se que o token é inválido
    }
};



export const getUserRole = () => {
    const token = localStorage.getItem("token");
    if (!token) {
        console.log("Token não encontrado!");
        return null;
    } else {
        try {
            const decoded = jwtDecode(token);
            console.log("Decoded Token:", decoded);
            console.log("Categoria:", decoded.categoria);
            return decoded.categoria;
        } catch (error) {
            console.error("Erro ao decodificar o token:", error);
            return null;
        }
}
}
