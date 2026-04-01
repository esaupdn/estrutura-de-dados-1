const minhaFila = new Fila(5);

function adicionarElemento() {
  const nomeElemento = document.getElementById("txtnovoNome");
  const cpfElemento = document.getElementById("txtCpf");

  if (nomeElemento.value === "" || cpfElemento.value === "") {
    alert("Preencha o Nome e o CPF!");
    return; 
  }

 
  const novoAtendimento = new Atendimento(nomeElemento.value, cpfElemento.value);

  // Coloca o objeto na fila
  if (minhaFila.enqueue(novoAtendimento)) {
    mostrarFila();
    nomeElemento.value = "";
    cpfElemento.value = "";
    nomeElemento.focus();
  } else {
    alert("Fila cheia!");
  }
}

function mostrarFila() {
  const filaElemento = document.getElementById("listFila");
  filaElemento.innerHTML = "";
  
  for(let item of minhaFila) {
    const listItem = document.createElement("li");
    
    listItem.textContent = `Nome: ${item.nome} | CPF: ${item.cpf} | Chegada: ${item.data} às ${item.hora}`;
    filaElemento.appendChild(listItem);
  }
}

function removerElemento() {
  let removido = minhaFila.dequeue();
  if(removido === null) {
    alert("Fila vazia");
  } else {
    alert("Atendido: " + removido.nome);
    mostrarFila();
  }
}

function buscarElemento() {
  const buscaCpf = document.getElementById("txtCpf").value;
  
  if (buscaCpf === "") {
    alert("Digite o CPF no campo apropriado para buscar.");
    return;
  }

  let encontrado = false;
  for(let item of minhaFila) {
     if(buscaCpf === item.cpf) {
      alert(`Encontrado na fila: ${item.nome} (Chegou em ${item.data} às ${item.hora})`);
      encontrado = true;
      break;
     }
  }
  
  if(!encontrado) {
    alert("Pessoa não está na fila");
  }
}