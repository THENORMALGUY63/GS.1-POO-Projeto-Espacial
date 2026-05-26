public class DadosMissao {
    private String coordenadas;
    private double nivelCombustivel; // Porcentagem 0 a 100
    private String trajetoria;
    private int numeroTripulantes;
    private final String SENHA_ACESSO = "FIAP2026";

    public DadosMissao(String coordenadasInicial, String trajetoria, int tripulantes) {
        this.coordenadas = coordenadasInicial;
        this.nivelCombustivel = 100.0;
        this.trajetoria = trajetoria;
        this.numeroTripulantes = tripulantes;
    }

    // Coordenadas protegidas por senha
    public String getCoordenadas(String senha) {
        if (this.SENHA_ACESSO.equals(senha)) {
            return coordenadas;
        }
        return "ACESSO NEGADO: Senha incorreta.";
    }

    public void setCoordenadas(String coordenadas, String senha) {
        if (this.SENHA_ACESSO.equals(senha)) {
            this.coordenadas = coordenadas;
            System.out.println("Coordenadas atualizadas com sucesso.");
        } else {
            System.out.println("Erro: Acesso negado para alteração.");
        }
    }

    // Validação de Combustível
    public double getNivelCombustivel() {
        return nivelCombustivel;
    }

    public void consumirCombustivel(double quantidade) {
        if (quantidade < 0) {
            System.out.println("Erro: Não é possível consumir um valor negativo.");
            return;
        }
        this.nivelCombustivel -= quantidade;
        if (this.nivelCombustivel < 0) this.nivelCombustivel = 0;
        
        // Alerta automático
        if (this.nivelCombustivel < 20.0) {
            System.out.println("[ALERTA CRÍTICO] Nível de combustível abaixo de 20%!");
        }
    }

    // Getters e Setters básicos
    public String getTrajetoria() { return trajetoria; }
    public void setTrajetoria(String trajetoria) { this.trajetoria = trajetoria; }
    
    public int getNumeroTripulantes() { return numeroTripulantes; }
    public void setNumeroTripulantes(int numero) { 
        if (numero >= 0) this.numeroTripulantes = numero; 
    }
}