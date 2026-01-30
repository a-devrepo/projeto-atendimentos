package entities;

import java.util.UUID;

public class Atendimento {

    private UUID id;
    private String usuario;
    private String pergunta;
    private String resposta;

    public Atendimento() {
    }

    public Atendimento(UUID id, String usuario, String pergunta, String resposta) {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
