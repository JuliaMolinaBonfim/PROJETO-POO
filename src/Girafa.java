package src;

public class Girafa extends Mamifero {
    private double tamanhoPescoco;

    public Girafa(String nome, int idade, double peso, String cor, boolean vivo,
                  String habitat, double altura, boolean emExtincao,
                  String locomocao, boolean domesticado, String habitoAlimentar, double tamanhoPescoco) {

        super(nome, idade, peso, cor, vivo, habitat, altura, emExtincao, locomocao, domesticado, habitoAlimentar);

        this.tamanhoPescoco = tamanhoPescoco;
    }

    public void emitirSom() {
        System.out.println(getNome() + " está gritando e fazendo barulhos engraçados!");
    }

    public void comerFolha() {
        System.out.println(getNome() + " está comendo as folhinhas!");
    }
}
