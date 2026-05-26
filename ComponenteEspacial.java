public abstract class ComponenteEspacial {
    protected int id;
    protected String nome;
    protected boolean status; // true = ligado, false = desligado
    protected double temperatura;

    public ComponenteEspacial(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.status = false;
        this.temperatura = 20.0; // Temperatura ambiente padrão
    }

    // Métodos concretos comuns
    public void ligar() {
        this.status = true;
        System.out.println(nome + " ligado.");
    }

    public void desligar() {
        this.status = false;
        System.out.println(nome + " desligado.");
    }

    // Método abstrato que as subclasses DEVEM implementar
    public abstract void realizarDiagnostico();
    
    // Getters
    public String getNome() { return nome; }
    public boolean isStatus() { return status; }
}