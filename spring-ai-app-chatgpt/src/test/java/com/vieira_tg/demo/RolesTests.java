package com.vieira_tg.demo;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RolesTests {

    @Autowired
    private ChatModel model;

    private ChatClient chatClient;

    @Test
    @DisplayName("Primeiro prompt com roles")
    void teste_1() {
        chatClient = ChatClient
                .builder(model)
                .build();

        val response = chatClient.prompt()
                .system("Você é um sistema especialista em critica literaria e ao final dara também um resumo de 5 linhas do livro")
                .user("Diga 5 frases do mochileiro das galaxias")
                .call()
                .chatResponse()
                .getResult();

        System.out.println(response);
    }
}
