// Instancia a fila com 5 posições (igual no vídeo)
const minhaFila = new FilaCircular(5);

function adicionar() {
    const input = document.getElementById("novoNome");
    const nome = input.value;

    if (nome !== "") {
        minhaFila.enq(nome);
        input.value = ""; // Limpa o input
        atualizarTela();
    }
}

function atender() {
    const removido = minhaFila.deq();
    if (removido) {
        alert("Atendendo: " + removido);
        atualizarTela();
    }
}

function atualizarTela() {
  
    const display = document.getElementById("displayFila");
    display.textContent = JSON.stringify(minhaFila.elementos);
    console.log("Estado atual:", minhaFila);
}