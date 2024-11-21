package com.vieira_tg.demo;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ToolsFunctionTests {

	@Autowired
	private ChatModel model;

	private ChatClient chatClient;

	@Test
	@DisplayName("Teste de execução de funções (Tools)")
	void teste_1(){
		chatClient = ChatClient
				.builder(model)
				.defaultFunctions("resultResponseService")
				.build();

		val response = chatClient.prompt()
				.user("Como se deve utilizar a toalha? ")
				.call();


		System.out.println(response.content());
	}
}
