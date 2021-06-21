package sample.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @GetMapping("/messages")
    public String[] getMessages() {
        return new String[]{"Hello", "Hi!", "It's worked"};
    }
}

