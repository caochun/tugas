package info.nemoworks.tugas.framework.message;

import lombok.Getter;
import org.springframework.context.PayloadApplicationEvent;

import java.util.UUID;

public class Message<T> extends PayloadApplicationEvent<T> {

    @Getter
    private final UUID id = UUID.randomUUID();

    public Message(Object source, T payload) {
        super(source, payload);
    }

}
