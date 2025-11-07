import java.util.ArrayList;

public class Zoologico {
    private String nome;
    private ArrayList<Animal> animais;

    public Zoologico(String nome) {
        this.nome = nome;
        this.animais = new ArrayList<>();
    }

    public void adicionarAnimal(Animal animal) {
        animais.add(animal);
    }

    public void listarAnimais() {
        System.out.println("Animais do zoológico" + nome + ":");
        for (Animal a: animais) {
            System.out.println("- " + a.getNome());
        }
    }

    public ArrayList<Animal> getAnimais() {
        return animais;
    }
}
