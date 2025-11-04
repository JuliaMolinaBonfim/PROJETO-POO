public class Hipopotamo extends Mamifero {

    public Hipopotamo(String nome, int idade, double peso, String cor, boolean vivo,
                      String habitat, double tamanho, double altura, boolean emExtincao,
                      String locomocao, boolean domesticado, String habitoAlimentar) {

        super(nome, idade, peso, cor, vivo, habitat, tamanho, altura, emExtincao,
                locomocao, domesticado, habitoAlimentar);
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
