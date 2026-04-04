package bg.sofia.uni.fmi.mjt.eventbus.events;

public final class MessageSentEvent extends BaseEvent implements Event<MessageSentPayload> {

    private final MessageSentPayload payload;

    public MessageSentEvent(MessageSentPayload payload, int priority, String source) {
        super(priority, source);

        this.payload = payload;
    }

    @Override
    public MessageSentPayload getPayload() {
        return this.payload;
    }
}
