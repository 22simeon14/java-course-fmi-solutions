package bg.sofia.uni.fmi.mjt.eventbus.events;

import bg.sofia.uni.fmi.mjt.eventbus.data.Message;

public class MessageSentPayload implements Payload<Message> {

    private final Message message;
    private final int size;

    public MessageSentPayload(Message message, int size) {
        if (message == null) {

            throw new IllegalArgumentException("Message sent can not be null!");
        }
        if (size < 0) {
            throw new IllegalArgumentException("Message paylaod size can not be <0!");
        }

        this.message = message;
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public Message getPayload() {
        return this.message;
    }
}
