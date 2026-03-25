class FilaCircular {
    constructor(tamanho) {
        this.elementos = new Array(tamanho);
        this.inicio = 0;
        this.fim = -1;
        this.quantidade = 0;
    }

    isEmpty() {
        return this.quantidade === 0;
    }

    isFull() {
        return this.quantidade === this.elementos.length;
    }

    enq(elemento) {
        if (this.isFull()) {
            alert("Fila cheia!");
            return;
        }

        if (this.fim === this.elementos.length - 1) {
            this.fim = 0;
        } else {
            this.fim++;
        }

        this.elementos[this.fim] = elemento;
        this.quantidade++;
    }

    deq() {
        if (this.isEmpty()) {
            alert("Fila vazia!");
            return null;
        }

        let removido = this.elementos[this.inicio];

        if (this.inicio === this.elementos.length - 1) {
            this.inicio = 0;
        } else {
            this.inicio++;
        }

        this.quantidade--;
        return removido;
    }
}