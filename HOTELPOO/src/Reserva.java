import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Reserva extends OperacaoReserva implements Arquivo {

    private Map<String, Quarto> reservas;

    public Reserva() {
        reservas = new HashMap<>();
    }

    public void adicionarReserva(String idHospede, Quarto quarto) {
        reservas.put(idHospede, quarto);
    }

    @Override
    public void executar() {
        System.out.println("Processando reservas...");
    }

    @Override
    public void salvarEmArquivo(String nomeArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (var entrada : reservas.entrySet()) {
                writer.write("Hospede ID: " + entrada.getKey() + ", " + entrada.getValue() + "\\n");
            }
        }
    }

    @Override
    public void lerDeArquivo(String nomeArquivo) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        }
    }

    @Override
    public String toString() {
        return "Reserva [reservas=" + reservas + "]";
    }
}