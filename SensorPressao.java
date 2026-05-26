public class SensorPressao implements Sensor {
    private boolean operante = true;

    @Override
    public double lerValor() {
        // Simula uma pressão entre 0.0 e 2000.0 kPa
        return Math.random() * 2000.0;
    }

    @Override
    public boolean verificarFuncionamento() {
        return operante;
    }

    @Override
    public String retornarTipo() {
        return "Pressão";
    }
}