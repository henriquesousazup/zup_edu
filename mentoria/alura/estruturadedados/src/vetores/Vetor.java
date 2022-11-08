package vetores;

import java.util.Arrays;


/*
* Armazenamento Sequencial -> Array -> Vetor
* Ideia -> Guardar um objeto do lado do outro
*
* O Java já possui uma implementação de vetores.Vetor, o ArrayList, que é semelhante à essa classe
* */
public class Vetor {

    private Aluno[] alunos = new Aluno[100];
    private int totalDeAlunos = 0;

    public void adiciona(int posicao, Aluno aluno) {

        garantirEspaco();

        if (!posicaoValida(posicao)) {
            throw new IllegalArgumentException("Posição inválida");
        }

        /*
         * Abre um buraco no array e adiciona aluno na posição escolhida, porém é outro algorítimo O(N)
         * */
        for (int i = totalDeAlunos - 1; i >= posicao; i -= 1) {
            alunos[i + 1] = alunos[i];
        }
        alunos[posicao] = aluno;
        totalDeAlunos++;
    }

    public void adiciona(Aluno aluno) {

        garantirEspaco();

        alunos[totalDeAlunos] = aluno;
        totalDeAlunos++;

        /* Primeira opção, nada performatica, pois precisa passar sempre pelo if
         Caso tenha muitos alunos, vai passar muitas vezes pelo if -> O(N) */

       /* for(int i=0; i< alunos.length; i++){
            if(alunos[i] == null){
                alunos[i] = aluno;
                break;
            }
          } */
    }

    public Aluno pega(int posicao) {

        if (!posicaoOcupada(posicao)) {
            throw new IllegalArgumentException();
        }

        return alunos[posicao];
    }

    public void remove(int posicao) {
        /*
         * Move todos os valores da direita para a esquerda removendo o valor que está na posição escolhida O(N)
         * */
        for (int i = posicao; i < totalDeAlunos; i++) {
            alunos[i] = alunos[i + 1];
        }

        totalDeAlunos--;
    }

    public boolean contem(Aluno aluno) {

        // O(N)
        for (int i = 0; i < totalDeAlunos; i++) {
            if (aluno.equals(alunos[i])) {
                return true;
            }
        }

        return false;
    }

    public int tamanho() {
        return alunos.length;
    }

    public String toString() {
        return Arrays.toString(alunos);
    }

    private void garantirEspaco() {
        if (totalDeAlunos == alunos.length) {
            Aluno[] novoArray = new Aluno[alunos.length * 2];
            for (int i = 0; i < alunos.length; i++) {
                novoArray[i] = alunos[i];
            }
            alunos = novoArray;
        }
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < totalDeAlunos;
    }

    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao <= totalDeAlunos;
    }
}
