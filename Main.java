import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Animal> zoologico = new ArrayList<>();
        System.out.println("oiiiiiiii==UYGGIUiiiiiiiiiiiiiiii");
        zoologico.add(new Hipopotamo("Bubu", 7, 1500, "cinza", true,
                "rio", 3.5, 1.2, false, "andar", false, "herbívoro"));

        zoologico.add(new Macaco("Kiki", 3, 35, "marrom", true,
                "floresta", 1.2, 0.8, false, "pular", true, "onívoro", "12cm"));

        zoologico.add(new Cobra("Naja", 4, 6.2, "verde", true,
                "floresta", 1.5, 0.2, false, "rastejar", true, "escamosa", true, "Jiboia"));

        zoologico.add(new Jacare("Guto", 9, 300, "verde escuro", true,
                "pântano", 2.5, 0.7, false, "nadar", false, "escamosa", true, "50"));

        System.out.println("\n🐾=== ZOOLÓGICO DOS ANIMAIS ===🐾\n");

        for (Animal a : zoologico) {
            System.out.println("➡️  Animal: " + a.getNome() + " (" + a.getClass().getSimpleName() + ")");
            System.out.println("Habitat: " + a.getHabitat());
            System.out.println("Cor: " + a.getCor());
            System.out.println("Peso: " + a.getPeso() + " kg");
            System.out.println("Altura: " + a.getAltura() + " m");
            System.out.println("Locomoção: " + a.getLocomocao());
            System.out.println("Em extinção: " + (a.isEmExtincao() ? "Sim" : "Não"));
            System.out.println("Vivo: " + (a.isVivo() ? "Sim" : "Não"));
            System.out.println("----------------------------------");

            a.emitirSom();
            a.mover();

            if (a instanceof Macaco) {
                ((Macaco) a).pular();
                ((Macaco) a).brincarComOutros();
                ((Macaco) a).comerBanana();
            } else if (a instanceof Hipopotamo) {
                ((Hipopotamo) a).mergulhar();
                ((Hipopotamo) a).abrirBoca();
                ((Hipopotamo) a).correrNaAgua();
            } else if (a instanceof Cobra) {
                ((Cobra) a).darBote();
                ((Cobra) a).enrolar();
                ((Cobra) a).mudarDePele();
            } else if (a instanceof Jacare) {
                ((Jacare) a).nadar();
                ((Jacare) a).morder();
                ((Jacare) a).tomarSol();
            }
            System.out.println("==================================\n");
        }
    }
}