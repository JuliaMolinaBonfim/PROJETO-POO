abstract class Animal {
    private String nome;
    private int idade;
    private double peso;
    private String cor;
    private boolean vivo;
    private String habitat;
    private double altura;
    private boolean emExtincao;
    private String locomocao;

    public Animal(String nome, int idade, double peso, String cor, boolean vivo, String habitat, double altura, boolean emExtincao, String locomocao) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.cor = cor;
        this.vivo = vivo;
        this.habitat = habitat;
        this.altura = altura;
        this.emExtincao = emExtincao;
        this.locomocao = locomocao;

    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getLocomocao() {
        return locomocao;
    }
    public void setLocomocao(String locomocao) {
        this.locomocao = locomocao;
    }

    public boolean isEmExtincao() {
        return emExtincao;
    }
    public void setEmExtincao(boolean emExtincao) {
        this.emExtincao = emExtincao;
    }

    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getHabitat() {
        return habitat;
    }
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public boolean isVivo() {
        return vivo;
    }
    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public abstract void emitirSom();

    public void mover() {
        System.out.println(nome + " está se locomovendo (" + locomocao + ").");
    }

    public void comer() {
        System.out.println(nome + " está se alimentando.");
    }

    public void dormir() {
        System.out.println(nome + " está dormindo.");
    }
}
