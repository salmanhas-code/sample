package com.salman.deepseek_ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeepSeekOllamaController {

    private final ChatClient chatClient;

    public DeepSeekOllamaController(@Qualifier("ollamaChatClient") ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/deepseek-ollama/{m}")
    public String chat(@PathVariable String m){
        return chatClient
                .prompt()
                .user(m)
                .call()
                .content();
    }

}
