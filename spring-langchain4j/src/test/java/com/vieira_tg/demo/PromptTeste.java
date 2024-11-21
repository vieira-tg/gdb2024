package com.vieira_tg.demo;


import com.vieira_tg.demo.service.AssistantService;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PromptTeste {

    @Autowired
    private AssistantService assistantService;

    @Test
    @DisplayName("Deve imprimir a resposta de um prompt")
    void teste_1() {

        val message = "Faça um resumo da serie de livros mochileiros das galaxias";

        val retorno = assistantService.chat(message);

        System.out.println(retorno);
    }
}
