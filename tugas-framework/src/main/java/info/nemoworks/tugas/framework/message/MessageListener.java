package info.nemoworks.tugas.framework.message;

import org.springframework.context.ApplicationListener;

import java.util.function.Consumer;

public class MessageListener<T extends Message> implements ApplicationListener<T> {

    private Consumer<T> messageHandle;

    public MessageListener(Consumer<T> handle) {
        this.messageHandle = handle;
    }

    @Override
    public void onApplicationEvent(T event) {
        this.messageHandle.accept(event);
    }
}
