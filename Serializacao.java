import java.io.*;

public class Serializacao {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Usuario usuario1 = new Usuario("Isabela", "09875076996", "05/06/2007", "21/11/2025", "15:00", "Curitiba", "Lazer");
        salvarUsuario(usuario1);

        Usuario usuario2 = carregarUsuario();
        System.out.println(usuario2);
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
