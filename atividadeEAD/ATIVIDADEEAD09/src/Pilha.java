import java.util.Iterator;

public class Pilha<T> implements Iterable<T> {
    private No<T> topo;
    
    public Pilha() {
        this.topo = null;
    }
    public boolean isFull() {
        return false; 
    }

    public boolean isEmpty() {
        return this.topo == null;
    }

    public boolean push(T elemento) {
        No<T> novoNo = new No<>(elemento);
        novoNo.setProximo(this.topo); // O novo nó aponta pro antigo topo
        this.topo = novoNo;           // O topo passa a ser o novo nó
        return true;
    }

    public T pop() {
        if (!isEmpty()) {
            T removido = this.topo.getDado();
            this.topo = this.topo.getProximo(); // Topo desce um nível
            return removido;
        }
        return null;
    }

    public T peek() {
        if (!isEmpty()) {
            return this.topo.getDado();
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder pilha = new StringBuilder("*** Topo ***\n");
        No<T> atual = this.topo;
        
        while (atual != null) {
            pilha.append(atual.getDado()).append("\n");
            atual = atual.getProximo();
        }
        
        pilha.append("__________\n");
        return pilha.toString();
    }

    // Implementação do Iterator exigida na aula
    @Override
    public Iterator<T> iterator() {
        return new PilhaIterator();
    }

    private class PilhaIterator implements Iterator<T> {
        private No<T> atual = topo;

        @Override
        public boolean hasNext() {
            return atual != null;
        }

        @Override
        public T next() {
            T elementoRetorno = atual.getDado();
            atual = atual.getProximo();
            return elementoRetorno;
        }
    }
}