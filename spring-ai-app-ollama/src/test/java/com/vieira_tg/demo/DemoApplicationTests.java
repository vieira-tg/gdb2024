package com.vieira_tg.demo;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private OllamaChatModel chatModel;

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("Deve imprimir a resposta de um prompt ao ollma")
    void teste_1() {


        val teste =  chatModel.call(new Prompt(
                "Me dê 5 frases do livro mochileiro das galaxias, em português",
                OllamaOptions.builder()
                        .withModel(OllamaModel.LLAMA2)
                        .withTemperature(0.9f)
                        .build()
        ));

        System.out.println(teste.getResult().getOutput().getContent());
    }
}
