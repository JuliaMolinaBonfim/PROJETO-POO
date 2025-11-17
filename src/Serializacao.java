

import java.io.*;
import java.util.*;

public class Serializacao {
    private static final String ARQUIVO = "src/usuarios.csv";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            System.out.println("\n===== MENU DE USUÁRIOS =====");
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
                        salvarUsuario(usuario);
                        System.out.println("\n✅ Usuário salvo com sucesso!");
                    } catch (IOException e) {
                        System.out.println("❌ Erro ao salvar usuário: " + e.getMessage());
                    }
                    break;

                case "2":
                    try {
                        List<Usuario> usuarios = carregarUsuarios();
                        if (usuarios.isEmpty()) {
                            System.out.println("\n⚠️ Nenhum usuário cadastrado ainda.");
                        } else {
                            System.out.println("\nUsuários cadastrados:\n");
                            for (Usuario u : usuarios) {
                                System.out.println(u);
                                System.out.println("---------------------------");
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("❌ Erro ao ler usuários: " + e.getMessage());
                    }
                    break;

                case "3":
                    try {
                        List<Usuario> usuarios = carregarUsuarios();
                        System.out.print("Digite o CPF (apenas números) que deseja editar: ");
                        String cpfBusca = sanitizarCpf(scanner.nextLine().trim());

                        Usuario usuario = buscarUsuarioPorCpf(cpfBusca);
                        if (usuario == null) {
                            System.out.println("⚠️ Nenhum usuário com esse CPF foi encontrado.");
                            break;
                        }

                        System.out.print("Novo nome (atual: " + usuario.getNome() + "): ");
                        String novoNome = scanner.nextLine();
                        if (!novoNome.isBlank()) usuario.setNome(novoNome);

                        System.out.print("Novo CPF (atual: " + usuario.getCpf() + "): ");
                        String novoCpf = scanner.nextLine().trim();
                        if (!novoCpf.isBlank() && apenasDigitos(novoCpf))
                            usuario.setCpf(sanitizarCpf(novoCpf));

                        System.out.print("Nova data de nascimento (atual: " + usuario.getDataNascimento() + "): ");
                        String novaDataNascimento = scanner.nextLine();
                        if (!novaDataNascimento.isBlank()) usuario.setDataNascimento(novaDataNascimento);

                        System.out.print("Nova data da visita (atual: " + usuario.getDataVisita() + "): ");
                        String novaDataVisita = scanner.nextLine();
                        if (!novaDataVisita.isBlank()) usuario.setDataVisita(novaDataVisita);

                        System.out.print("Nova hora de entrada (atual: " + usuario.getHoraEntrada() + "): ");
                        String novaHoraEntrada = scanner.nextLine();
                        if (!novaHoraEntrada.isBlank()) usuario.setHoraEntrada(novaHoraEntrada);

                        System.out.print("Nova cidade (atual: " + usuario.getCidade() + "): ");
                        String novaCidade = scanner.nextLine();
                        if (!novaCidade.isBlank()) usuario.setCidade(novaCidade);

                        System.out.print("Novo motivo da visita (atual: " + usuario.getMotivoVisita() + "): ");
                        String novoMotivo = scanner.nextLine();
                        if (!novoMotivo.isBlank()) usuario.setMotivoVisita(novoMotivo);

                        editarUsuario(cpfBusca, usuario);
                        System.out.println("\n✅ Informações atualizadas com sucesso!");
                    } catch (IOException e) {
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

    // === CADASTRO ===
    public static Usuario cadastrarUsuario(Scanner scanner) {
        System.out.print("Digite o seu nome completo: ");
        String nome = scanner.nextLine();

        String cpf;
        while (true) {
            System.out.print("Digite o seu CPF (apenas números): ");
            cpf = sanitizarCpf(scanner.nextLine().trim());
            if (apenasDigitos(cpf)) break;
            System.out.println("⚠️ CPF inválido. Tente novamente.");
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

    // === SALVAR E LER CSV ===
    public static void salvarUsuarios(List<Usuario> usuarios) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
            writer.write("nome,cpf,dataNascimento,dataVisita,horaEntrada,cidade,motivoVisita");
            writer.newLine();
            for (Usuario u : usuarios) {
                writer.write(String.join(",",
                        u.getNome(),
                        u.getCpf(),
                        u.getDataNascimento(),
                        u.getDataVisita(),
                        u.getHoraEntrada(),
                        u.getCidade(),
                        u.getMotivoVisita()
                ));
                writer.newLine();
            }
        }
    }

    public static void salvarUsuario(Usuario usuario) throws IOException {
        List<Usuario> usuarios = carregarUsuarios();
        usuarios.add(usuario);
        salvarUsuarios(usuarios);
    }

    public static List<Usuario> carregarUsuarios() throws IOException {
        List<Usuario> usuarios = new ArrayList<>();
        File arquivo = new File(ARQUIVO);
        if (!arquivo.exists()) return usuarios;

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            reader.readLine(); // cabeçalho
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",", -1);
                if (partes.length == 7) {
                    Usuario u = new Usuario(partes[0], partes[1], partes[2],
                            partes[3], partes[4], partes[5], partes[6]);
                    usuarios.add(u);
                }
            }
        }
        return usuarios;
    }

    // agora recebe o CPF antigo e o novo usuário
    public static boolean editarUsuario(String cpfAntigo, Usuario usuarioAtualizado) throws IOException {
        List<Usuario> usuarios = carregarUsuarios();
        boolean encontrado = false;

        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            if (u.getCpf().equals(cpfAntigo)) {
                usuarios.set(i, usuarioAtualizado);
                encontrado = true;
                break;
            }
        }

        if (encontrado) salvarUsuarios(usuarios);
        return encontrado;
    }

    // === BUSCA POR CPF ===
    public static Usuario buscarUsuarioPorCpf(String cpf) {
        try {
            for (Usuario u : carregarUsuarios()) {
                if (u.getCpf().equals(cpf)) return u;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // === FUNÇÕES AUXILIARES ===
    public static boolean apenasDigitos(String s) {
        return s != null && s.matches("\\d+");
    }

    public static String sanitizarCpf(String s) {
        return (s == null) ? "" : s.replaceAll("\\D", "");
    }
}
