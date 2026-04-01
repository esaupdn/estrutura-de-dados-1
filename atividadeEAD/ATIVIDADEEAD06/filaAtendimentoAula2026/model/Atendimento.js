class Atendimento {
    constructor(nome, cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.data = obterDataAtual(); // Puxa do util.js
        this.hora = obterHoraAtual(); // Puxa do util.js
    }
}