package bg.sofia.uni.fmi.mjt.eventbus.subscribers;

import bg.sofia.uni.fmi.mjt.eventbus.events.Event;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeferredEventSubscriber<T extends Event<?>> implements Subscriber<T>, Iterable<T> {

    private final List<T> eventContainer;

    public DeferredEventSubscriber() {
        this.eventContainer = new ArrayList<>();
    }

    /**
     * Store an event for processing at a later time.
     *
     * @param event the event to be processed
     * @throws IllegalArgumentException if the event is null
     */
    @Override
    public void onEvent(T event) {
        if (event == null) {
            throw new IllegalArgumentException("The event subcribed to can not be null!");
        }

        eventContainer.add(event);
    }

    /**
     * Get an iterator for the unprocessed events. The iterator should provide the
     * events sorted
     * by priority, with higher-priority events first (lower priority number =
     * higher priority).
     * For events with equal priority, earlier events (by timestamp) come first.
     *
     * @return an iterator for the unprocessed events
     */
    @Override
    public Iterator<T> iterator() {
        List<T> sortedEventList = new ArrayList<>(eventContainer);

        for (int i = 0; i < sortedEventList.size(); i++) {
            boolean swapped = false;
            for (int j = 0; j < sortedEventList.size() - i - 1; j++) {
                if (sortedEventList.get(j).getPriority() > sortedEventList.get(j + 1).getPriority()) {
                    var temp = sortedEventList.get(j);
                    sortedEventList.set(j, sortedEventList.get(j + 1));
                    sortedEventList.set(j + 1, temp);
                    swapped = true;
                }
                if (sortedEventList.get(j).getPriority() == sortedEventList.get(j + 1).getPriority()) {
                    if (sortedEventList.get(j).getTimestamp()
                            .compareTo(sortedEventList.get(j + 1).getTimestamp()) > 0) {
                        var temp = sortedEventList.get(j);
                        sortedEventList.set(j, sortedEventList.get(j + 1));
                        sortedEventList.set(j + 1, temp);
                        swapped = true;
                    }
                }
            }
            if (!swapped)
                break;
        }

        return sortedEventList.iterator();
    }

    /**
     * Check if there are unprocessed events.
     *
     * @return true if there are no unprocessed events, false otherwise
     */
    public boolean isEmpty() {
        return eventContainer.isEmpty();
    }

}
