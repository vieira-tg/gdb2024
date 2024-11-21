package com.vieira_tg.demo.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface AssistantService {
    @SystemMessage("Você é especialista nos livros dos mochileiros das galaxias")
    String chat(String userMessage);
}
