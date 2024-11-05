package club.takeiteasyplease.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lambochen
 */
@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    // example: curl -X GET 'http://127.0.0.1:8080/chat/simple?input=who%20are%20you'
    @GetMapping("/simple")
    public String chat(@RequestParam("input") String input) {
        return this.chatClient.prompt()
                .user(input)
                .call()
                .content();
    }
}
