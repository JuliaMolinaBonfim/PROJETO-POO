public class Jacare extends Reptil {
    private String numDentes;

    public Jacare(String nome, int idade, double peso, String cor, boolean vivo,
                  String habitat, double altura, boolean emExtincao,
                  String locomocao, boolean venenoso, String tipoPele, boolean botaOvos, String numDentes) {

        super(nome, idade, peso, cor, vivo, habitat, altura, emExtincao,
                locomocao, venenoso, tipoPele, botaOvos);

        this.numDentes = numDentes;
    }

    public void emitirSom() {
        System.out.println(getNome() + " faz um rugido grave!");
    }

    public void nadar() {
        System.out.println(getNome() + " está nadando silenciosamente no rio.");
    }

    public void morder() {
        System.out.println(getNome() + " deu uma mordida em  um peixe!");
    }

    public void tomarSol() {
        System.out.println(getNome() + " está deitado tomando sol.");
    }

}
