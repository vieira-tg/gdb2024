package com.vieira_tg.demo;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.ai.chat.client.advisor.AbstractChatMemoryAdvisor.CHAT_MEMORY_CONVERSATION_ID_KEY;

@SpringBootTest
class RagEmbeddingTests {
	private static final Integer CHAT_ID = 1;

	@Autowired
	private ChatModel model;


	@Autowired
	private ChatMemory chatMemory;


	private ChatClient chatClient;

	@Autowired
	private VectorStore vectorStore;

	@Test
	@DisplayName("Testando RAG e Embedding")
	void teste_1(){

		chatClient = ChatClient.builder(model)
				.defaultAdvisors(new QuestionAnswerAdvisor(vectorStore, SearchRequest.defaults()))
				.build();


		val response = chatClient.prompt()
				.user("Qual é o melhor livro da serie mochileiro das galaxias?")
				.call()
				.content();

		System.out.println(response);
	}







}
