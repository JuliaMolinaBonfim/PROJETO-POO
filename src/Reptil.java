package src;

public class Reptil extends Animal {
    private boolean venenoso;
    private String tipoPele;
    private boolean botaOvos;

    public Reptil(String nome, int idade, double peso, String cor, boolean vivo,
                  String habitat, double altura, boolean emExtincao,
                  String locomocao, boolean venenoso, String tipoPele, boolean botaOvos) {
        super(nome, idade, peso, cor, vivo, habitat, altura, emExtincao, locomocao);
        this.venenoso = venenoso;
        this.tipoPele = tipoPele;
        this.botaOvos = botaOvos;
    }

    public String getTipoPele() {
        return tipoPele;
    }

    public void setTipoPele(String tipoPele) {
        this.tipoPele = tipoPele;
    }

    public boolean isVenenoso() {
        return venenoso;
    }

    public void setVenenoso(boolean venenoso) {
        this.venenoso = venenoso;
    }

    public boolean isBotaOvos() {
        return botaOvos;
    }

    public void setBotaOvos(boolean botaOvos) {
        this.botaOvos = botaOvos;
    }

    public void emitirSom() {
        System.out.println(getNome() + " está fazendo um som de réptil.");
    }

    public void rastejar() {
        System.out.println(getNome() + " está rastejando silenciosamente.");
    }

    public void trocarDePele() {
        System.out.println(getNome() + " está trocando de pele (" + tipoPele + ").");
    }

    public void botarOvos() {
        if (botaOvos) {
            System.out.println(getNome() + " está botando ovos.");
        } else {
            System.out.println(getNome() + " não bota ovos.");
        }
    }

    public void atacar() {
        if (venenoso) {
            System.out.println(getNome() + " te envenenou!");
        } else {
            System.out.println(getNome() + " apenas te mordeu!");
        }
    }

    public void mostrarFicha() {
        System.out.println("\n=== Ficha do Réptil ===");
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Peso: " + getPeso() + " kg");
        System.out.println("Cor: " + getCor());
        System.out.println("Habitat: " + getHabitat());
        System.out.println("Tipo de pele: " + tipoPele);
        System.out.println("Venenoso: " + (venenoso ? "Sim" : "Não"));
        System.out.println("Bota ovos: " + (botaOvos ? "Sim" : "Não"));
        System.out.println("=========================\n");
    }
}