package bg.sofia.uni.fmi.mjt.eventbus.events;

public final class UserLogoutEvent extends BaseEvent implements Event<LogoutPayload> {

    private final LogoutPayload payload;

    public UserLogoutEvent(LogoutPayload payload, int priority, String source) {
        super(priority, source);

        this.payload = payload;

    }

    @Override
    public LogoutPayload getPayload() {
        return this.payload;
    }
}
