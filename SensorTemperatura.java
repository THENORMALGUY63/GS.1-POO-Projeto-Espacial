public class SensorTemperatura implements Sensor {
    private boolean operante = true;

    @Override
    public double lerValor() {
        // Simula uma temperatura entre -50.0 e 150.0
        return -50.0 + (Math.random() * 200.0);
    }

    @Override
    public boolean verificarFuncionamento() {
        return operante;
    }

    @Override
    public String retornarTipo() {
        return "Temperatura";
    }
}