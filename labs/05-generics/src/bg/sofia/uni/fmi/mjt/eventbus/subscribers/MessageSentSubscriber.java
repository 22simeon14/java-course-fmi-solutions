package bg.sofia.uni.fmi.mjt.eventbus.subscribers;

import bg.sofia.uni.fmi.mjt.eventbus.events.MessageSentEvent;

public class MessageSentSubscriber implements Subscriber<MessageSentEvent> {

    @Override
    public void onEvent(MessageSentEvent event) {
        if (event == null) {
            throw new IllegalArgumentException("Event can not be null!");
        }

        System.out.println("User : " + event.getPayload().getPayload().getSender().getUsername()
                + "sent a message to : " + event.getPayload().getPayload().getReceiver().getUsername()
                + "at : " + event.getTimestamp());
    }
}
