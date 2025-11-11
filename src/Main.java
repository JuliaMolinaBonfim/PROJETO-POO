package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Zoologico zoologico = new Zoologico("Zoo das Poderosas");

        System.out.println("Olá! Seja bem-vindo(a)!");
        zoologico.adicionarAnimal(new Hipopotamo("Juju", 7, 1500, "cinza", true,
                "rio", 3.5 , false, "andar", false, "herbívoro", "50s"));

        zoologico.adicionarAnimal(new Macaco("Kiki", 3, 35, "marrom", true,
                "floresta", 1.2 , false, "pular", true, "onívoro", "12cm"));

        zoologico.adicionarAnimal(new Cobra("Naja", 4, 6.2, "laranja", true,
                "floresta", 1.5, false, "rastejar", true, "escamosa", true, "Jiboia"));

        zoologico.adicionarAnimal(new Jacare("Guto", 9, 300, "verde escuro", true,
                "pântano", 2.5, false, "nadar", false, "escamosa", true, "50"));

        zoologico.adicionarAnimal(new Girafa("Alex", 8, 800, "Amarela e Preta", true, "Terrestre", 1, false,
                "Patas", false, "Folhas", 30));

        System.out.println("\n🐾=== ZOO DAS PODEROSAS ===🐾\n");

        for (Animal a : zoologico.getAnimais()) {
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
            } else if (a instanceof Girafa) {
                ((Girafa) a).comerFolha();
            }
            System.out.println("==================================\n");
        }

        Scanner scanner = new Scanner(System.in);
        String nomeBuscado;

        while (true) {
            System.out.print("\nDigite o nome do animal que deseja buscar (ou 'sair' para encerrar): ");
            nomeBuscado = scanner.nextLine();

            if (nomeBuscado.equalsIgnoreCase("sair")) {
                System.out.println("\n👋 Encerrando o programa. Obrigado por visitar o Zoo das Poderosas!");
                break;
            }

            try {
                Animal encontrado = zoologico.buscarAnimalPorNome(nomeBuscado);
                System.out.println("\n✅ Animal encontrado!");
                System.out.println("Nome: " + encontrado.getNome());
                System.out.println("Espécie: " + encontrado.getClass().getSimpleName());
                System.out.println("Habitat: " + encontrado.getHabitat());
                System.out.println("Peso: " + encontrado.getPeso() + " kg");
                System.out.println("Altura: " + encontrado.getAltura() + " m");
            } catch (AnimalNaoEncontradoException e) {
                System.out.println("\n⚠️ Erro: " + e.getMessage());
            }
        }

        scanner.close();
    }
}