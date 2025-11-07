import java.io.*;
import java.util.Scanner;

public class Serializacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite o seu nome completo: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o seu CPF: ");
            String cpf = scanner.nextLine();

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

            Usuario usuario = new Usuario(nome, cpf, dataNascimento, dataVisita, horaEntrada, cidade, motivoVisita);
            salvarUsuario(usuario);

            System.out.println("\n✅ Usuário salvo com sucesso!\n");

            Usuario usuarioCarregado = carregarUsuario();
            System.out.println("Usuário carregado do arquivo:\n");
            System.out.println(usuarioCarregado);

        } catch (FileNotFoundException e) {
            System.out.println("❌ Erro: o arquivo não foi encontrado.");
        } catch (IOException e) {
            System.out.println("❌ Erro ao salvar ou ler o arquivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Erro: classe Usuario não encontrada.");
        } catch (Exception e) {
            System.out.println("⚠️ Ocorreu um erro inesperado: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    public static void salvarUsuario(Usuario usuario) throws IOException{
        FileOutputStream fos = new FileOutputStream("usuario.txt");

        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(usuario);
        os.close();
        fos.close();
    }
    public static Usuario carregarUsuario() throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream("usuario.txt");

        ObjectInputStream is = new ObjectInputStream(fis);

        Usuario usuario = (Usuario) is.readObject();

        is.close();

        fis.close();
        return usuario;
    }
}
