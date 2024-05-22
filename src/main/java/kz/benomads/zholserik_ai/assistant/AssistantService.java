package kz.benomads.zholserik_ai.assistant;


import org.springframework.stereotype.Service;

@Service
public class AssistantService {

    private final Assistant assistant;

    public AssistantService(Assistant assistant) {
        this.assistant = assistant;
    }

    public String answer(int memoryId, String userMessage) {
        return assistant.chat(memoryId, userMessage).toString();
    }



}
