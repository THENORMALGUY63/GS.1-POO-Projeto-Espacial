public class SensorRadiacao implements Sensor {
    private boolean operante = true;

    @Override
    public double lerValor() {
        // Simula níveis de radiação entre 0.0 e 10.0 Sv
        return Math.random() * 10.0;
    }

    @Override
    public boolean verificarFuncionamento() {
        return operante;
    }

    @Override
    public String retornarTipo() {
        return "Radiação";
    }
}