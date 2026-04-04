package bg.sofia.uni.fmi.mjt.eventbus.events;

public final class UserLoginEvent extends BaseEvent implements Event<LoginPayload> {

    private final LoginPayload payload;

    public UserLoginEvent(LoginPayload payload, int priority, String source) {
        super(priority, source);

        this.payload = payload;
    }

    @Override
    public LoginPayload getPayload() {
        return this.payload;
    }
}
