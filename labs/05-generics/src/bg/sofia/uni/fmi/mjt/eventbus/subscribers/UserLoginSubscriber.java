package bg.sofia.uni.fmi.mjt.eventbus.subscribers;

import bg.sofia.uni.fmi.mjt.eventbus.events.UserLoginEvent;

public class UserLoginSubscriber implements Subscriber<UserLoginEvent> {

    @Override
    public void onEvent(UserLoginEvent event) {
        if (event == null) {
            throw new IllegalArgumentException("Event can not be null!");
        }

        System.out.println("User : " + event.getPayload().getPayload().getUsername()
                + "logged in at : "
                + event.getTimestamp());
    }
}
