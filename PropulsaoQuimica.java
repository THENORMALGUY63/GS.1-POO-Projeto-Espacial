public class PropulsaoQuimica extends SistemaPropulsao {
    private String tipoCombustivel; // Atributo específico

    public PropulsaoQuimica(int id, String nome, double potenciaMax, String tipoCombustivel) {
        super(id, nome, potenciaMax); // Chama o construtor da classe mãe
        this.tipoCombustivel = tipoCombustivel;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
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
        
        // Calculando empuxo gerado
        this.empuxoAtual = (porcentagemPotencia / 100.0) * potenciaMax;
        
        // AQUI ESTÁ A CORREÇÃO: Usando a variável 'tipoCombustivel' no print para sumir com o Warning!
        System.out.println(nome + " (Química) queimando " + this.tipoCombustivel + " e acelerando. Empuxo: " + this.empuxoAtual + " kN.");
    }
}