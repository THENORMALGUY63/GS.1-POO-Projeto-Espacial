public abstract class SistemaPropulsao extends ComponenteEspacial {
    protected double empuxoAtual;
    protected double potenciaMax;

    public SistemaPropulsao(int id, String nome, double potenciaMax) {
        // Chamando o construtor da classe mãe ComponenteEspacial
        super(id, nome); 
        this.potenciaMax = potenciaMax;
        this.empuxoAtual = 0;
    }

    // Método a ser sobrescrito pelas subclasses
    public abstract void acelerar(double porcentagemPotencia);

    @Override
    public void realizarDiagnostico() {
        System.out.println("Diagnosticando " + nome + ". Status: " + (status ? "Ativo" : "Inativo") + ". Empuxo atual: " + empuxoAtual);
    }
    
    public double getEmpuxoAtual() {
        return empuxoAtual;
    }
}