package bg.sofia.uni.fmi.mjt.eventbus.events;

import java.time.Instant;

public abstract sealed class BaseEvent permits UserLoginEvent, UserLogoutEvent, MessageSentEvent {
    
    private final Instant timestamp;
    private final int priority;
    private final String source;

    public BaseEvent(int priority, String source) {
        if(priority < 0) {
            throw new IllegalArgumentException("Event priority can not be < 0!");
        }
        if(source == null || source.isBlank()) {
            throw new IllegalArgumentException("Event source can not be null or blank!");
        }

        this.priority = priority;
        this.source = source;
        this.timestamp = Instant.now();
    }

    public int getPriority() {
        return this.priority;
    }

    public String getSource() {
        return this.source;
    }

    public Instant getTimestamp() {
        return this.timestamp;
    }
}
