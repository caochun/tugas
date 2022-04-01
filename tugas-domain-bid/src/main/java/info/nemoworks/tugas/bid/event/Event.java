package info.nemoworks.tugas.bid.event;

import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

public class Event {
    @Getter
    private UUID id;
    @Getter
    private Instant timestamp;
    @Getter
    private String eventString;

    public Event(String eventString) {
        this.id = UUID.randomUUID();
        this.timestamp = Instant.now();
        this.eventString = eventString;
    }
}
