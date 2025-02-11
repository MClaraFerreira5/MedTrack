import Header from "../../Componentes/Header"
import { UserCircleIcon, Bell, Section } from "lucide-react"
import Perfil from "../../Componentes/Perfil"
import Medicacoes from "../../Componentes/Medicacoes/Medicacoes"


const PerfilDependente = () =>{
    const name = "Jaison"
    return(
        <div >
        <header className="flex items-center gap-10 md:w-4/5 justify-center mx-auto md:pr-10">
            <Header h1={`Olá, ${name}`} exibirPesquisa={true}/>
            <Bell size={40} color="cyan" className="hidden sm:block"></Bell>
        </header>
        
        <main className="sm:flex 2xl:flex-col md:w-4/5 gap-5 justify-center mx-auto">
            <section className="mx-auto h-screen border border-cyan-300 rounded-lg p-10 ml-3 hidden sm:block ">
                <Perfil vaiTer={true}/>
            </section>
            <section className="mx-auto w-full h-screen">
                <Medicacoes/>
            </section>
        </main>
        </div>
    )
}

export default PerfilDependente