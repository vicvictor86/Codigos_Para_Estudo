class InsuficientData extends Error {
    constructor(){
        super("Não foram fornecidos dados para atualizar");
        this.name = "InsuficientData";
        this.idErro = 2;
    }
}

module.exports = InsuficientData;