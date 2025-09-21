package com.brianlukonsolo.Controller;

import com.brianlukonsolo.services.OllamaService;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ChatController {

    @Autowired
    private OllamaService service;

    // Request DTO
    public record AskAnythingRequest(String question) {}

    // Response DTO
    public record AskAnythingResponse(String question, String answer) {}

    @PostMapping(
            value = "/api/chat",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public AskAnythingResponse askAnythingJson(@RequestBody AskAnythingRequest req) {
        ChatResponse response = service.generateAnswer(req.question());
        String answer = response.getResult().getOutput().getContent();
        return new AskAnythingResponse(req.question(), answer);
    }
}
