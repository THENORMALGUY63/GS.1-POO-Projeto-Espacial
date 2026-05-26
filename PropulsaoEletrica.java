public class PropulsaoEletrica extends SistemaPropulsao {
    private double eficienciaIonica; // Atributo específico

    public PropulsaoEletrica(int id, String nome, double potenciaMax, double eficienciaIonica) {
        super(id, nome, potenciaMax);
        this.eficienciaIonica = eficienciaIonica;
    }

    @Override
    public void acelerar(double porcentagemPotencia) {
        if (!status) {
            System.out.println("Erro: " + nome + " está desligado.");
            return;
        }
        if (porcentagemPotencia < 0 || porcentagemPotencia > 100) {
            System.out.println("Erro: Potência deve estar entre 0 e 100.");
            return;
        }
        
        // Comportamento diferente: o empuxo da elétrica sofre modificação pela eficiência
        this.empuxoAtual = ((porcentagemPotencia / 100.0) * potenciaMax) * eficienciaIonica;
        System.out.println(nome + " (Elétrica) acelerando silenciosamente. Empuxo: " + this.empuxoAtual + " kN.");
    }
}