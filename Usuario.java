import java.io.Serializable;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private String cpf;
    private String dataNascimento;
    private String dataVisita;
    private String horaEntrada;
    private String horaSaida;
    private String cidade;
    private String motivoVisita;

    public Usuario(String nome, String cpf, String dataNascimento, String dataVisita, String horaEntrada, String cidade, String motivoVisita) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.dataVisita = dataVisita;
        this.horaEntrada = horaEntrada;
        this.horaSaida = "18:30";
        this.cidade = cidade;
        this.motivoVisita = motivoVisita;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataVisita() {
        return dataVisita;
    }
    public void setDataVisita(String dataVisita) {
        this.dataVisita = dataVisita;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }
    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSaida() {
        return horaSaida;
    }
    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getMotivoVisita() {
        return motivoVisita;
    }
    public void setMotivoVisita(String motivoVisita) {
        this.motivoVisita = motivoVisita;
    }

    public String toString() {
        return "Visitante: " + nome +
                "\nCPF: " + cpf +
                "\nData de nascimento: " + dataNascimento +
                "\nData da visita: " + dataVisita +
                "\nHora de entrada: " + horaEntrada +
                "\nFechamento do zoológico: " + horaSaida +
                "\nLocal visitado: " + cidade +
                "\nMotivo da visita: " + motivoVisita;
    }
}
