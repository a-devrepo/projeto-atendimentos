package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class OpenAIService {

    public OpenAIService() {}

    public String enviarPergunta(String usuario, String pergunta) throws Exception {

        var endpoint = "https://api.openai.com/v1/responses";

        var secretKey = "";

        var promptSistema =
                "Você é um atendente de suporte de TI para atender dúvidas dos usuários. Responda de forma cordial e objetiva. Responda apenas perguntas relacionadas a assuntos de suporte de TI. Para perguntas fora do escopo do suporte de TI, responda que não pode ajudar.";

        var promptUsuario = String.format("Meu nome é %s, e minha dúvida é: %s", usuario,pergunta);

        var json = """
                {
                "model": "gpt-4.1",
                "input": "%s"
                }
                """.formatted(promptSistema + promptUsuario);

        var body = RequestBody.create(json, MediaType.parse("application/json"));
        var request = new Request.Builder()
                .url(endpoint)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + secretKey)
                .post(body)
                .build();

        var http = new OkHttpClient.Builder().build();
        var response = http.newCall(request).execute();

        return extrairResposta(response.body().string());
    }

    private String extrairResposta(String jsonResponse) throws JsonMappingException, JsonProcessingException {
        var mapper = new ObjectMapper();
        var root = mapper.readTree(jsonResponse);

        String resposta = root
                .path("output").get(0)
                .path("content").get(0)
                .path("text")
                .asText();

        return resposta.replace("\\n", "\n");
    }
}
