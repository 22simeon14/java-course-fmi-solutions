package bg.sofia.uni.fmi.mjt.eventbus;

import bg.sofia.uni.fmi.mjt.eventbus.events.Event;
import bg.sofia.uni.fmi.mjt.eventbus.exception.MissingSubscriptionException;
import bg.sofia.uni.fmi.mjt.eventbus.subscribers.Subscriber;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class EventBusImpl implements EventBus {

    private final Map<Class<? extends Event<?>>, List<Subscriber<?>>> subscriptions;
    private final Map<Class<? extends Event<?>>, List<Event<?>>> eventLog;

    public EventBusImpl() {
        subscriptions = new HashMap<Class<? extends Event<?>>, List<Subscriber<?>>>();
        eventLog = new HashMap<Class<? extends Event<?>>, List<Event<?>>>();
    }

    @Override
    public <T extends Event<?>> void subscribe(Class<T> eventType, Subscriber<? super T> subscriber) {
        if (eventType == null) {
            throw new IllegalArgumentException("Event type to subscribe to can not be null!");
        }
        if (subscriber == null) {
            throw new IllegalArgumentException("Subscriber can not be null!");
        }

        if (subscriptions.get(eventType) == null) {
            subscriptions.put(eventType, new ArrayList<>());
        }

        if (subscriptions.get(eventType).contains(subscriber)) {
            return;
        }

        subscriptions.get(eventType).add(subscriber);
    }

    @Override
    public <T extends Event<?>> void unsubscribe(Class<T> eventType, Subscriber<? super T> subscriber)
            throws MissingSubscriptionException {
        if (eventType == null) {
            throw new IllegalArgumentException("Event type to subscribe to can not be null!");
        }
        if (subscriber == null) {
            throw new IllegalArgumentException("Subscriber can not be null!");
        }

        if (subscriptions.get(eventType) == null) {
            throw new MissingSubscriptionException("No such subscription!");
        }

        if (!subscriptions.get(eventType).contains(subscriber)) {
            throw new MissingSubscriptionException("No such subscription!");
        }

        subscriptions.get(eventType).remove(subscriber);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Event<?>> void publish(T event) {
        if (event == null) {
            throw new IllegalArgumentException("Event to publish can not be null!");
        }

        List<Subscriber<?>> subscribers = subscriptions.get(event.getClass());
        if (subscribers != null) {
            for (Subscriber<?> subscriber : subscribers) {
                Subscriber<? super T> typedSubscriber = (Subscriber<? super T>) subscriber;
                typedSubscriber.onEvent(event);
            }
        }

        Class<? extends Event<?>> eventType = (Class<? extends Event<?>>) event.getClass();
        eventLog.putIfAbsent(eventType, new ArrayList<>());
        eventLog.get(eventType).add(event);
    }

    @Override
    public void clear() {
        subscriptions.clear();
        eventLog.clear();
    }

    @Override
    public Collection<? extends Event<?>> getEventLogs(Class<? extends Event<?>> eventType, Instant from, Instant to) {
        if (eventType == null) {
            throw new IllegalArgumentException("Event type can not be null!");
        }
        if (from == null) {
            throw new IllegalArgumentException("Timestamp from can not be null!");
        }
        if (to == null) {
            throw new IllegalArgumentException("Timestamp to can not be null!");
        }

        if (from.equals(to)) {
            return new ArrayList<>();
        }

        List<Event<?>> result = new ArrayList<>();
        if (eventLog.get(eventType) == null) {
            return result;
        }

        List<Event<?>> eventLogValues = eventLog.get(eventType);
        for (Event<?> event : eventLogValues) {
            if (event.getTimestamp().compareTo(from) >= 0
                    && event.getTimestamp().compareTo(to) < 0) {
                result.add(event);
            }
        }

        return Collections.unmodifiableList(result);
    }

    @Override
    public <T extends Event<?>> Collection<Subscriber<?>> getSubscribersForEvent(Class<T> eventType) {
        if (eventType == null) {
            throw new IllegalArgumentException("Event type can not be null!");
        }

        if (subscriptions.get(eventType) == null || subscriptions.get(eventType).isEmpty()) {
            return Collections.unmodifiableList(new ArrayList<>());
        }

        return Collections.unmodifiableList(subscriptions.get(eventType));
    }

}