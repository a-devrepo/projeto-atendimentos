package controllers;

import entities.Atendimento;
import repositories.AtendimentoRepository;
import services.OpenAIService;

import java.util.Scanner;
import java.util.UUID;

public class AtendimentoController {

    private final Scanner scanner;
    private final OpenAIService openAIService;
    private final AtendimentoRepository repository;

    public AtendimentoController(Scanner scanner,
                                 OpenAIService openAIService,
                                 AtendimentoRepository atendimentoRepository) {
        this.scanner = scanner;
        this.openAIService = openAIService;
        this.repository = atendimentoRepository;
    }

    public void gerarAtendimento() {

        try {

            var atendimento = new Atendimento();

            atendimento.setId(UUID.randomUUID());

            System.out.println("\nATENDENTE VIRTUAL");

            System.out.print("\nInforme seu nome.......................: ");
            atendimento.setUsuario(scanner.nextLine());

            System.out.print("\nDigite sua pergunta....................: ");
            atendimento.setPergunta(scanner.nextLine());

            var resposta = openAIService.enviarPergunta(atendimento.getUsuario(), atendimento.getPergunta());

            System.out.println(resposta);

            atendimento.setResposta(resposta);

            repository.inserir(atendimento);

        } catch (Exception e) {
            System.err.println("Erro ao gerar atendimento: " + e.getMessage());
        }
    }
}
