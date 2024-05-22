package kz.benomads.zholserik_ai.assistant;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/assistant")
public class AssistantController {

    private final AssistantService assistantService;

    public AssistantController(AssistantService assistantService) {
        this.assistantService = assistantService;
    }

    @GetMapping("/chat2")
    public String chat2(@RequestParam("userMessage") String userMessage,
                       @RequestParam("id") int id) {
        return assistantService.answer(id, userMessage);
    }


}
