import controllers.AtendimentoController;
import factories.ConnectionFactory;
import repositories.AtendimentoRepository;
import services.OpenAIService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        var connectionFactory = ConnectionFactory.getConnectionFactory();
        var atendimentoRepository = new AtendimentoRepository(connectionFactory);
        var atendimentoService = new OpenAIService();
        var atendimentoController = new AtendimentoController(new Scanner(System.in), atendimentoService, atendimentoRepository);
        atendimentoController.gerarAtendimento();
    }
}
