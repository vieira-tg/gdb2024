package com.vieira_tg.demo;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.ai.chat.client.advisor.AbstractChatMemoryAdvisor.CHAT_MEMORY_CONVERSATION_ID_KEY;

@SpringBootTest
class PromptMemoriaTests {
    private static final Integer CHAT_ID = 1;

    @Autowired
    private ChatModel model;

    @Autowired
    private ChatMemory chatMemory;

    private ChatClient chatClient;

    @Test
    @DisplayName("Prompt sem memoria")
    void teste_1() {
        chatClient = ChatClient
                .builder(model)
                .build();

        val response = chatClient
                .prompt()
                .user("Vamos conversar sobre mochileiro das galaxias?")
                .call()
                .content();

        System.out.println(response);

        System.out.println("================================================================");

        val response2 = chatClient
                .prompt()
                .user("Sobre o que estavamos falando?")
                .call()
                .content();

        System.out.println(response2);
    }

    @Test
    @DisplayName("Teste de chat (Com memoria)")
    void teste_2() {

        chatClient = ChatClient
                .builder(model)
                .defaultAdvisors(new MessageChatMemoryAdvisor(chatMemory))
                .build();

        val response = chatClient
                .prompt()
                .user("Vamos conversar sobre mochileiro das galaxias?")
                .advisors(a -> a.param(CHAT_MEMORY_CONVERSATION_ID_KEY, CHAT_ID))
                .call()
                .content();

        System.out.println(response);

        System.out.println("================================================================");

        val response2 = chatClient
                .prompt()
                .user("Sobre o que estavamos falando?")
                .advisors(a -> a.param(CHAT_MEMORY_CONVERSATION_ID_KEY, CHAT_ID))
                .call()
                .content();

        System.out.println(response2);
    }
}
