package repositories;

import entities.Atendimento;
import factories.ConnectionFactory;

public class AtendimentoRepository {

    private final ConnectionFactory connectionFactory;

    public AtendimentoRepository(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public void inserir(Atendimento atendimento) {

        try (var connection = connectionFactory.getConnection()) {

            var sql = """
                    INSERT INTO atendimentos (id, usuario, pergunta, resposta)
                     VALUES (?, ?, ?, ?)""";

            var statement = connection.prepareStatement(sql);
            statement.setObject(1, atendimento.getId());
            statement.setString(2, atendimento.getUsuario());
            statement.setString(3, atendimento.getPergunta());
            statement.setString(4, atendimento.getResposta());

            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir atendimento", e);
        }
    }
}
