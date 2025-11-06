public class Usuario {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String dataVisita;
    private String horaEntrada;
    private String horaSaida;
    private String cidade;
    private String motivoVisita;

    public Usuario(String nome, String cpf, String dataNascimento, String dataVisita, String horaEntrada, String horaSaida, String cidade, String motivoVisita) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.dataVisita = dataVisita;
        this.horaEntrada = horaEntrada;
        this.cidade = cidade;
        this.motivoVisita = motivoVisita;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getDataVisita() { return dataVisita; }
    public void setDataVisita(String dataVisita) { this.dataVisita = dataVisita; }

    public String getHoraEntrada() { return horaEntrada; }
    public void setHoraEntrada(String horaEntrada) { this.horaEntrada = horaEntrada; }

    public String getHoraSaida() { return horaSaida; }
    public void setHoraSaida(String horaSaida) { this.horaSaida = horaSaida; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getMotivoVisita() { return motivoVisita; }
    public void setMotivoVisita(String motivoVisita) { this.motivoVisita = motivoVisita; }

    public void exibirInfo() {
        System.out.println("Visitante: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Data de nascimento: " + dataNascimento);
        System.out.println("Data da visita: " + dataVisita);
        System.out.println("Hora de entrada: " + horaEntrada);
        System.out.println("Fechamento do zoológico: " + horaSaida);
        System.out.println("Local visitado: " + cidade);
        System.out.println("Motivo da visita: " + motivoVisita);
    }
}
