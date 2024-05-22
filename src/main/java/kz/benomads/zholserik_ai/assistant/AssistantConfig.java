package kz.benomads.zholserik_ai.assistant;

import com.vaadin.flow.component.page.AppShellConfigurator;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.memory.chat.TokenWindowChatMemory;
import dev.langchain4j.model.Tokenizer;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import dev.langchain4j.model.openai.OpenAiTokenizer;
import dev.langchain4j.service.AiServices;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AssistantConfig implements AppShellConfigurator {

    @Bean
    StreamingChatLanguageModel streamingChatLanguageModel(@Value("${OPEN_AI_API_KEY}") String apiKey) {
        return OpenAiStreamingChatModel.builder()
            .modelName("gpt-4o")
            .apiKey(apiKey)
            .build();
    }

    @Bean
    ChatLanguageModel model(@Value("${OPEN_AI_API_KEY}") String apiKey) {
        return OpenAiChatModel.builder()
            .apiKey(apiKey)
            .modelName("gpt-4o")
            .build();
    }

    @Bean
    Tokenizer tokenizer() {
        return new OpenAiTokenizer("gpt-4o");
    }

    @Bean
    Assistant assistant(ChatLanguageModel model) {
        return AiServices.builder(Assistant.class)
            .chatLanguageModel(model)
            .chatMemoryProvider(memoryId -> MessageWindowChatMemory.withMaxMessages(10))
            .build();
    }


}
