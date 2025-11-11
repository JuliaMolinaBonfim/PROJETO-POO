package src;

public class Mamifero extends Animal {
    private boolean domesticado;
    private String habitoAlimentar;

    public Mamifero(String nome, int idade, double peso, String cor, boolean vivo,
                    String habitat, double altura, boolean emExtincao,
                    String locomocao, boolean domesticado, String habitoAlimentar) {

        super(nome, idade, peso, cor, vivo, habitat, altura, emExtincao, locomocao);
        this.domesticado = domesticado;
        this.habitoAlimentar = habitoAlimentar;

    }

    public String getHabitoAlimentar() {
        return habitoAlimentar;
    }

    public void setHabitoAlimentar(String habitoAlimentar) {
        this.habitoAlimentar = habitoAlimentar;
    }

    public boolean isDomesticado() {
        return domesticado;
    }

    public void setDomesticado(boolean domesticado) {
        this.domesticado = domesticado;
    }

    public void emitirSom() {
        System.out.println(getNome() + " está emitindo um som típico de mamífero.");
    }

    public void dormir() {
        System.out.println(getNome() + " está dormindo tranquilamente.");
    }

    public void comer() {
        System.out.println(getNome() + " está comendo. Tipo de alimento: " + habitoAlimentar);
    }

    public void brincar() {
        if (domesticado) {
            System.out.println(getNome() + " está brincando com humanos!");
        } else {
            System.out.println(getNome() + " está brincando na natureza!");
        }
    }

    public void mostrarFicha() {
        System.out.println("\n=== Ficha do Mamífero ===");
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Peso: " + getPeso());
        System.out.println("Cor: " + getCor());
        System.out.println("Habitat: " + getHabitat());
        System.out.println("Alimentação: " + habitoAlimentar);
        System.out.println("Domesticado: " + (domesticado ? "Sim" : "Não"));
        System.out.println("==========================\n");
    }
}