package src;

public class Cobra extends Reptil {
    private String especie;

    public Cobra(String nome, int idade, double peso, String cor, boolean vivo,
                 String habitat, double altura, boolean emExtincao,
                 String locomocao, boolean venenoso, String tipoPele, boolean botaOvos, String especie) {

        super(nome, idade, peso, cor, vivo, habitat, altura, emExtincao,
                locomocao, venenoso, tipoPele, botaOvos);

        this.especie = especie;
    }

    public void emitirSom() {
        System.out.println(getNome() + " fez 'ssssss'!");
    }

    public void darBote() {
        System.out.println(getNome() + " tentou dar um bote!");
    }

    public void enrolar() {
        System.out.println(getNome() + " se enrolou em volta da presa!");
    }

    public void mudarDePele() {
        System.out.println(getNome() + " está trocando de pele.");
    }
}
