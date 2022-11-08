package vetores;

public class VetorTeste {
    public static void main(String[] args) {
        Aluno a1 = new Aluno("João");
        Aluno a2 = new Aluno("José");

        Vetor lista = new Vetor();

        lista.adiciona(a1);
        lista.adiciona(a2);

        System.out.println(lista);
        System.out.println(lista.contem(a1));

        Aluno a3 = new Aluno("Henrique");
        System.out.println(lista.contem(a3));

        Aluno a4 = new Aluno("Danilo");
        lista.adiciona(1, a4);
        System.out.println(lista);

        lista.remove(1);
        System.out.println(lista);

        for (int i = 0; i < 300; i++) {
            Aluno a = new Aluno("João " + i);
            lista.adiciona(a);
        }

        System.out.println(lista);
        System.out.println(lista.tamanho());
    }
}