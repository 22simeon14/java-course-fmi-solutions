package bg.sofia.uni.fmi.mjt.eventbus.subscribers;

import bg.sofia.uni.fmi.mjt.eventbus.events.UserLogoutEvent;

public class UserLogoutSubscriber implements Subscriber<UserLogoutEvent> {

    @Override
    public void onEvent(UserLogoutEvent event) {
        if (event == null) {
            throw new IllegalArgumentException("Event can not be null!");
        }

        System.out.println("user: " + event.getPayload().getPayload().getUsername()
                + "logged out at : "
                + event.getTimestamp());
    }
}
