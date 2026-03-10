public class PilhaRecordes {

    private Recorde[] pilha;
    private int topo;

    public PilhaRecordes(int tamanhoInicial) {
        pilha = new Recorde[tamanhoInicial];
        topo = -1;
    }

    private void resize() {
        Recorde[] nova = new Recorde[pilha.length * 2];

        for (int i = 0; i < pilha.length; i++) {
            nova[i] = pilha[i];
        }

        pilha = nova;

        System.out.println("Pilha redimensionada para: " + pilha.length);
    }

    public boolean push(Recorde r) {

        if (topo >= 0) {
            if (r.getTempo() >= pilha[topo].getTempo()) {
                System.out.println("Tempo não é melhor que o recorde atual.");
                return false;
            }
        }

        if (topo + 1 == pilha.length) {
            resize();
        }

        topo++;
        pilha[topo] = r;

        return true;
    }

    public Recorde pop() {

        if (topo == -1) {
            System.out.println("Pilha vazia.");
            return null;
        }

        Recorde removido = pilha[topo];
        topo--;

        return removido;
    }

    public Recorde peek() {

        if (topo == -1) {
            return null;
        }

        return pilha[topo];
    }

    public void listar() {

        if (topo == -1) {
            System.out.println("Nenhum recorde.");
            return;
        }

        for (int i = topo; i >= 0; i--) {
            System.out.println(pilha[i]);
        }
    }
}