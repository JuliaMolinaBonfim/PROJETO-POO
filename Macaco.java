public class Macaco extends Mamifero {

    public Macaco(String nome, int idade, double peso, String cor, boolean vivo,
                  String habitat, double tamanho, double altura, boolean emExtincao,
                  String locomocao, boolean domesticado, String habitoAlimentar) {

        super(nome, idade, peso, cor, vivo, habitat, tamanho, altura, emExtincao,
                locomocao, domesticado, habitoAlimentar);
    }
    public void emitirSom() {
        System.out.println(getNome() + " está gritando e fazendo barulhos engraçados!");
    }

    public void pular() {
        System.out.println(getNome() + " está pulando de galho em galho!");
    }

    public void comerBanana() {
        System.out.println(getNome() + " está comendo uma banana feliz!");
    }

    public void brincarComOutros() {
        System.out.println(getNome() + " está brincando com outros macacos.");
    }

}
