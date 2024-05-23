package kz.benomads.zholserik_ai.assistant;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/assistant")
public class AssistantController {

    private final AssistantService assistantService;

    public AssistantController(AssistantService assistantService) {
        this.assistantService = assistantService;
    }

    @GetMapping("/chat-with-token")
    public Flux<String> chatWithToken(@RequestParam("userMessage") String userMessage,
                                      @RequestParam("memoryId") int id) {
        if (userMessage == null || userMessage.isEmpty()) {
            return Flux.error(new IllegalArgumentException("User message cannot be empty"));
        }

        return assistantService.chatWithToken(id, userMessage);
    }


}
