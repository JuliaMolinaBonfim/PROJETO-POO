public class Hipopotamo extends Mamifero {
    private String tempoMergulho;

    public Hipopotamo(String nome, int idade, double peso, String cor, boolean vivo,
                      String habitat, double altura, boolean emExtincao,
                      String locomocao, boolean domesticado, String habitoAlimentar, String tempoMergulho) {

        super(nome, idade, peso, cor, vivo, habitat, altura, emExtincao,
                locomocao, domesticado, habitoAlimentar);

        this.tempoMergulho = tempoMergulho;
    }
    public void emitirSom() {
        System.out.println(getNome() + " faz um som alto de grunhido!");
    }

    public void mergulhar() {
        System.out.println(getNome() + " mergulhou e está mostrando seu narigão fora da água.");
    }

    public void abrirBoca() {
        System.out.println(getNome() + " abriu a boca mostrando seus dentões!");
    }

    public void correrNaAgua() {
        System.out.println(getNome() + " está correndo rapidamente dentro da água!");
    }
}
