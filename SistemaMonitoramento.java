import java.util.Scanner;

public class SistemaMonitoramento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Inicializando os sensores
        Sensor[] sensores = {
            new SensorTemperatura(),
            new SensorPressao(),
            new SensorRadiacao()
        };
        
        // Instanciando ambos os tipos de propulsão
        SistemaPropulsao motorQuimico = new PropulsaoQuimica(101, "Motor Principal Foguete", 5000.0, "Hidrazina");
        SistemaPropulsao motorEletrico = new PropulsaoEletrica(102, "Propulsor de Íons Auxiliar", 1500.0, 0.85);
        
        DadosMissao dados = new DadosMissao("23.5N 45.1W", "Orbita Terrestre", 4);
        
        boolean executando = true;
        
        System.out.println("=== BEM-VINDO À PLATAFORMA DE MONITORAMENTO ESPACIAL ===");
        
        while (executando) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Verificar Sensores e Alertas");
            System.out.println("2. Controlar Propulsão (Química / Elétrica)");
            System.out.println("3. Gerenciar Dados da Missão");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    verificarSensores(sensores);
                    break;
                case 2:
                    controlarPropulsao(motorQuimico, motorEletrico, scanner);
                    break;
                case 3:
                    gerenciarDados(dados, scanner);
                    break;
                case 4:
                    executando = false;
                    System.out.println("Desligando sistema. Boa viagem!");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }

    private static void verificarSensores(Sensor[] sensores) {
        System.out.println("\n--- STATUS DOS SENSORES ---");
        for (Sensor sensor : sensores) {
            double valor = sensor.lerValor();
            String tipo = sensor.retornarTipo();
            
            System.out.printf("Sensor de %s: %.2f\n", tipo, valor);
            
            if (tipo.equals("Temperatura")) {
                if (valor > 120) System.out.println("[CRÍTICO] Temperatura extremamente alta! Risco de dano estrutural.");
                else if (valor > 80) System.out.println("[ALERTA] Temperatura subindo. Acionar resfriamento.");
            } else if (tipo.equals("Pressão")) {
                if (valor > 1800) System.out.println("[CRÍTICO] Descompressão iminente ou alta pressão!");
                else if (valor > 1500) System.out.println("[ATENÇÃO] Pressão fora do padrão normal.");
            } else if (tipo.equals("Radiação")) {
                if (valor > 8.0) System.out.println("[CRÍTICO] Níveis letais de radiação detectados!");
                else if (valor > 5.0) System.out.println("[ALERTA] Exposição a radiação elevada. Tripulação deve se abrigar.");
            }
        }
    }

    private static void controlarPropulsao(SistemaPropulsao quimico, SistemaPropulsao eletrico, Scanner scanner) {
        System.out.println("\n--- CONTROLE DE PROPULSÃO ---");
        System.out.println("Escolha o motor que deseja operar:");
        System.out.println("1. " + quimico.getNome() + " (Química)");
        System.out.println("2. " + eletrico.getNome() + " (Elétrica)");
        System.out.print("Escolha: ");
        int escolhaMotor = scanner.nextInt();
        
        // Condição de erro: impede que opções além de 1 e 2 quebrem a lógica do polimorfismo
        if (escolhaMotor != 1 && escolhaMotor != 2) {
            System.out.println("Erro: Opção de motor inválida. Retornando ao menu principal...");
            return;
        }
        
        SistemaPropulsao motorSelecionado = (escolhaMotor == 2) ? eletrico : quimico;

        System.out.println("\nOperando: " + motorSelecionado.getNome());
        System.out.println("1. Ligar motor");
        System.out.println("2. Desligar motor");
        System.out.println("3. Acelerar");
        System.out.print("Escolha a ação: ");
        int acao = scanner.nextInt();
        
        if (acao == 1) motorSelecionado.ligar();
        else if (acao == 2) motorSelecionado.desligar();
        else if (acao == 3) {
            System.out.print("Digite a potência (0-100): ");
            double pot = scanner.nextDouble();
            motorSelecionado.acelerar(pot); 
        } else {
            System.out.println("Erro: Ação inválida.");
        }
    }

    private static void gerenciarDados(DadosMissao dados, Scanner scanner) {
        System.out.println("\n--- DADOS DA MISSÃO ---");
        System.out.println("Nível de Combustível: " + dados.getNivelCombustivel() + "%");
        System.out.print("Digite a senha para ver as coordenadas protegidas: ");
        scanner.nextLine(); // limpar buffer
        String senha = scanner.nextLine();
        
        System.out.println("Coordenadas: " + dados.getCoordenadas(senha));
        
        System.out.print("Deseja simular consumo de 15% de combustível? (s/n): ");
        String simular = scanner.nextLine();
        if (simular.equalsIgnoreCase("s")) {
            dados.consumirCombustivel(15.0); 
        }
    }
}