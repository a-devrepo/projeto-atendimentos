package controllers;

import entities.Atendimento;
import services.AtendimentoService;

import java.util.Scanner;

public class AtendimentoController {

    private final Scanner scanner;
    private final AtendimentoService atendimentoService;

    public AtendimentoController(Scanner scanner, AtendimentoService atendimentoService) {
        this.scanner = scanner;
        this.atendimentoService = atendimentoService;
    }

    public void gerarAtendimento() {

        try {

            var atendimento = new Atendimento();

            System.out.println("\nATENDENTE VIRTUAL");

            System.out.print("\nInforme seu nome.......................: ");
            atendimento.setUsuario(scanner.nextLine());

            System.out.print("\nDigite sua pergunta....................: ");
            atendimento.setPergunta(scanner.nextLine());

        } catch (Exception e) {
            System.err.println("Erro ao gerar atendimento: " + e.getMessage());
        }
    }
}
