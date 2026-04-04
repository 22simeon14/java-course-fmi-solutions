package bg.sofia.uni.fmi.mjt.eventbus.data;

import java.time.Instant;

public class Message {

    private User sender;
    private User receiver;
    private String messageContent;
    private Instant timestamp;

    public Message(User sender, User receiver, String content) {
        if (sender == null) {
            throw new IllegalArgumentException("Message sender can not be null!");
        }
        if (receiver == null) {
            throw new IllegalArgumentException("User receiver can not be null!");
        }
        if (content == null) {
            throw new IllegalArgumentException("Message content can not be null!");
        }

        this.sender = sender;
        this.receiver = receiver;
        this.messageContent = content;
        this.timestamp = Instant.now();
    }

    public User getSender() {
        return this.sender;
    }

    public User getReceiver() {
        return this.receiver;
    }

    public String getMessageContent() {
        return this.messageContent;
    }

    Instant getMessageTimeStamp() {
        return this.timestamp;
    }

}
