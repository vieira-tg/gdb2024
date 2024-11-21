package com.vieira_tg.demo;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PromptTests {
    @Autowired
    private ChatModel model;

    private ChatClient chatClient;

    @Test
    @DisplayName("Primeiro prompt")
    void teste_1() {
        chatClient = ChatClient
                .builder(model)
                .build();

        val response = chatClient.prompt()
                .user("Diga 5 frases do mochileiro das galaxias")
                .call()
                .chatResponse()
                .getResult();

        System.out.println(response);
    }

    @Test
    @DisplayName("Prompt template")
    void teste_2() {

        chatClient = ChatClient
                .builder(model)
                .build();

        val textoColetado = "gdg ?";

        val response = chatClient.prompt()
                .user(userSpec -> userSpec
                        .text("Relacionar com o livro mochileiro das galaxias {texto}")
                        .param("texto", textoColetado))
                .call()
                .chatResponse()
                .getResult();

        System.out.println(response);
    }
}
