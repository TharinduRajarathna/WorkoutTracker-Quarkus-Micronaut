package io.tharindu.workouttracker.message.service;

import io.tharindu.workouttracker.message.model.Message;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class MessageService {

    public Message add(Message message) {
        message.setId(UUID.randomUUID().toString());
        return message;
    }
}
