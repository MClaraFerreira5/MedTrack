const BoxMedicacao = ({ props }) => {
    return (
        <div className="flex flex-col gap-2">
            {props.map((d, index) => (
                <div key={index} className="flex border px-10 py-10 justify-between">  {/* Adicionando a chave para evitar warnings do React */}
                    <h2>{d.nome}</h2>
                    <p>{d.quantidade}</p>
                </div>
            ))}
        </div>
    );
};

export default BoxMedicacao;
