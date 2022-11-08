package listaligada;

public class ListaLigada {

    private Celula primeira = null;
    private Celula ultimo = null;
    private int totalDeElementos = 0;

    /*ADICIONA NO COMEÇO*/
    /* Processo de adicionar
    * elemento == novo
    * novo -> primeira -> elementox -> ultimo
    *  ***
    * primeiro (novo) -> próximo (primeiro) -> elementox -> ultimo
    */
    /* Caso a lista esteja vazia
    * novo -> null
    * **
    * primeiro (também ultimo e novo), null
    * */
    public void adicionaNoComeco(Object elemento) {
        Celula nova = new Celula(elemento, primeira);
        primeira = nova;

        if (this.totalDeElementos == 0) {
            ultimo = primeira;
        }

        totalDeElementos++;
    }

    /*ADICIONA NO FINAL*/
    /*Processo de adicionar
     * elemento == novo
     * primeiro -> elementox -> ultimo -> novo -> null
     * **
     * primeiro -> elementox -> elementoy -> ultimo -> null
     *
     * pega o ultimo da lista e seta o novo como próximo e define o novo como ultimo
     */
    /* Caso a lista esteja vazia
     * novo -> null
     * **
     * primeiro (também ultimo e novo), null
     * */
    public void adiciona(Object elemento) {

        if (this.totalDeElementos == 0) {
            adicionaNoComeco(elemento);
        } else {
            Celula nova = new Celula(elemento, null);
            ultimo.setProximo(nova);
            ultimo = nova;
            totalDeElementos++;
        }
    }

    /*ADICIONA EM ALGUMA POSIÇÃO*/
    /*
    * Pega o elemento da posição escolhida - 1 (anterior a posição escolhida), e para que um novo seja adicionado é necessário que o anterior da posição
    * fique sendo o anterior do novo elemento, e o próximo (que é o atual da posição) fique sendo o próximo do novo elemento, por exemplo -> posicao 2
    *
    * elemento0, elemento1, (posicao 2 aqui) elemento2, elemento3
    *
    * então o novo elemento deve ter o elemento1 como anterior, e o elemento2 como próximo
    *
    * elemento0, elemento1, novo, elemento2, elemento3
    *
    * para que isso aconteça é necessário adicionar o novo como próximo de elemento1, e elemento2 como próximo de novo
    * */
    /*
    * Caso queria adicionar na posição 0, usa-se a lógica da função de adicionar no começo
    * Caso queria adicionar na posição final (== total de elementos) usa-se a função adiciona para adicionar no final
    * */
    public void adiciona(int posicao, Object elemento) {

        if (posicao == 0) {
            adicionaNoComeco(elemento);
        } else if (posicao == totalDeElementos) {
            adiciona(elemento);
        } else {
            Celula anterior = this.pegaCelula(posicao - 1);
            Celula nova = new Celula(elemento, anterior.getProximo());
            anterior.setProximo(nova);

            this.totalDeElementos++;
        }

    }

    /*Pega elemento*/
    /*
    * Busca o elemento pela posição e retorna
    * */
    public Object pega(int posicao) {
        return this.pegaCelula(posicao).getElemento();
    }

    /* REMOVE DO COMEÇO*/
    /*
    * Apenas pega a primeira e troca pela próxima, e a antiga primeira vai para o garbage collector
    *
    * primeira -> proxima -> elementox -> ultimo
    *
    * primeira (que era a proxima) -> elementox -> ultimo
    * */
    public void removeDoComeco() {
        if (this.totalDeElementos == 0) {
            throw new IllegalArgumentException("Lista vazia");
        }

        this.primeira = this.primeira.getProximo();
        this.totalDeElementos--;

        if (this.totalDeElementos == 0) {
            this.ultimo = null;
        }

    }

    public void remove(int posicao) {

    }

    public int tamanho() {
        return this.totalDeElementos;
    }

    public boolean contem(Object o) {
        return false;
    }

    /*Método auxiliar para percorrer lista*/
    /*
    * Começa do primeiro elemento e dá next até chegar na posição desejada
    * */
    private Celula pegaCelula(int posicao) {

        if (!posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição inexistente");
        }

        Celula atual = primeira;

        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }

        return atual;
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < totalDeElementos;
    }

    @Override
    public String toString() {

        if (this.totalDeElementos == 0) {
            return "[]";
        }

        Celula atual = primeira;

        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < totalDeElementos; i++) {
            builder.append(atual.getElemento());
            builder.append(",");

            atual = atual.getProximo();
        }

        builder.append("]");

        return builder.toString();
    }
}
