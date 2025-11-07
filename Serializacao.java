import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Serializacao {
    private static final String ARQUIVO = "usuario.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            System.out.println("\n=====MENU DE USUÁRIOS=====");
            System.out.println("1️⃣  Cadastrar novo usuário");
            System.out.println("2️⃣  Mostrar todos os usuários");
            System.out.println("3️⃣  Editar usuário por CPF");
            System.out.println("4️⃣  Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    try {
                        Usuario usuario = cadastrarUsuario(scanner);
                        List<Usuario> usuarios = carregarUsuarios();
                        usuarios.add(usuario);
                        salvarUsuarios(usuarios);

                        System.out.println("\n✅ Usuário salvo com sucesso!");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("❌ Erro ao salvar usuário: " + e.getMessage());
                    }
                    break;

                case "2":
                    try {
                        List<Usuario> usuarios = carregarUsuarios();
                        if (usuarios.isEmpty()) {
                            System.out.println("\n⚠️Nenhum usuário cadastrado ainda.");
                        } else {
                            System.out.println("\nUsuários cadastrados:\n");
                            for (Usuario u : usuarios) {
                                System.out.println(u);
                                System.out.println("---------------------------");
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("❌ Erro ao ler usuários: " + e.getMessage());
                    }
                    break;

                case "3":
                    try {
                        List<Usuario> usuarios = carregarUsuarios();
                        String cpfBusca;
                        while (true) {
                            System.out.print("Digite o CPF (apenas números) que deseja editar: ");
                            cpfBusca = scanner.nextLine().trim();
                            cpfBusca = sanitizarCpf(cpfBusca);
                            if (apenasDigitos(cpfBusca)) {
                                break;
                            } else {
                                System.out.println("CPF inválido. Digite apenas números. Tente novamente.");
                            }
                        }

                        boolean encontrado = false;
                        for (Usuario u : usuarios) {
                            if (sanitizarCpf(u.getCpf()).equals(cpfBusca)) {
                                System.out.print("Novo nome (atual: " + u.getNome() + "): ");
                                String novoNome = scanner.nextLine();
                                if (!novoNome.isBlank()) u.setNome(novoNome);

                                System.out.print("Novo CPF (atual: " + u.getCpf() + "): ");
                                String novoCpf = scanner.nextLine().trim();
                                if (!novoCpf.isBlank()) {
                                    novoCpf = sanitizarCpf(novoCpf);
                                    if (apenasDigitos(novoCpf)) {
                                        u.setCpf(novoCpf);
                                    } else {
                                        System.out.println("⚠️ CPF inválido. Mantendo o anterior.");
                                    }
                                }

                                System.out.print("Nova data de nascimento (atual: " + u.getDataNascimento() + "): ");
                                String novaDataNascimento = scanner.nextLine();
                                if (!novaDataNascimento.isBlank()) u.setDataNascimento(novaDataNascimento);

                                System.out.print("Nova data da visita (atual: " + u.getDataVisita() + "): ");
                                String novaDataVisita = scanner.nextLine();
                                if (!novaDataVisita.isBlank()) u.setDataVisita(novaDataVisita);

                                System.out.print("Nova hora de entrada (atual: " + u.getHoraEntrada() + "): ");
                                String novaHoraEntrada = scanner.nextLine();
                                if (!novaHoraEntrada.isBlank()) u.setHoraEntrada(novaHoraEntrada);

                                System.out.print("Nova cidade (atual: " + u.getCidade() + "): ");
                                String novaCidade = scanner.nextLine();
                                if (!novaCidade.isBlank()) u.setCidade(novaCidade);

                                System.out.print("Novo motivo da visita (atual: " + u.getMotivoVisita() + "): ");
                                String novoMotivo = scanner.nextLine();
                                if (!novoMotivo.isBlank()) u.setMotivoVisita(novoMotivo);

                                encontrado = true;
                                break;
                            }
                        }
                        if (encontrado) {
                            salvarUsuarios(usuarios);
                            System.out.println("\n✅ Informações atualizadas com sucesso!");
                        } else {
                            System.out.println("⚠️ Nenhum usuário com esse CPF foi encontrado.");
                        }
                    } catch (Exception e) {
                        System.out.println("❌ Erro ao editar usuário: " + e.getMessage());
                    }
                    break;

                case "4":
                    System.out.println("\n👋 Saindo do programa. Até logo!");
                    executando = false;
                    break;

                default:
                    System.out.println("❌ Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }
    public static Usuario cadastrarUsuario(Scanner scanner) {
        System.out.print("Digite o seu nome completo: ");
        String nome = scanner.nextLine();

        String cpf;
        while (true) {
            System.out.print("Digite o seu CPF (apenas números): ");
            cpf = scanner.nextLine().trim();
            cpf = sanitizarCpf(cpf); // opcionalmente remove pontos/traços
            if (apenasDigitos(cpf)) {
                break;
            } else {
                System.out.println("CPF inválido. Digite apenas números (ex: 09875076996). Tente novamente.");
            }
        }

        System.out.print("Digite a data de nascimento (dd/mm/aaaa): ");
        String dataNascimento = scanner.nextLine();

        System.out.print("Digite a data da visita (dd/mm/aaaa): ");
        String dataVisita = scanner.nextLine();

        System.out.print("Digite a hora de entrada (hh:mm): ");
        String horaEntrada = scanner.nextLine();

        System.out.print("Digite a sua cidade: ");
        String cidade = scanner.nextLine();

        System.out.print("Digite o motivo da visita: ");
        String motivoVisita = scanner.nextLine();

        return new Usuario(nome, cpf, dataNascimento, dataVisita, horaEntrada, cidade, motivoVisita);
    }

    public static void salvarUsuarios(List<Usuario> usuarios) throws IOException{
        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(ARQUIVO))){
            os.writeObject(usuarios);
        }
    }
    public static List<Usuario> carregarUsuarios() throws IOException, ClassNotFoundException{
        File arquivo = new File(ARQUIVO);
        if(!arquivo.exists()){
            return new ArrayList<>();
        }
        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(arquivo))){
            return (List<Usuario>) is.readObject();
        }
    }
    public static boolean apenasDigitos(String s) {
        return s != null && s.matches("\\d+");
    }
    public static String sanitizarCpf(String s) {
        if (s == null) return "";
        return s.replaceAll("\\D", "");
    }
}
