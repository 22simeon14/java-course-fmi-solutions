package bg.sofia.uni.fmi.mjt.eventbus.events;

import bg.sofia.uni.fmi.mjt.eventbus.data.User;
import java.time.Instant;

public class LogoutPayload implements Payload<User> {
    private final User user;
    private final Instant logoutTime;
    private final int size;

    public LogoutPayload(User user, int size) {
        if (user == null) {
            throw new IllegalArgumentException("Logout user can not be null!");
        }
        if (size < 0) {
            throw new IllegalArgumentException("Logout payload size can not be < 0!");
        }

        this.size = size;
        this.user = user;
        this.logoutTime = Instant.now();
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public User getPayload() {
        return this.user;
    }

    public Instant getLogoutTime() {
        return this.logoutTime;
    }

}
