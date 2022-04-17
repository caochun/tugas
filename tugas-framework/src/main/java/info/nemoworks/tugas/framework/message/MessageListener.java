package info.nemoworks.tugas.framework.message;

import org.springframework.context.ApplicationListener;

import java.util.function.Consumer;

public class MessageListener<T extends Message> implements ApplicationListener<T> {

    private Consumer<T> messageConsumer;

    public MessageListener(Consumer<T> consumer) {
        this.messageConsumer = consumer;
    }

    @Override
    public void onApplicationEvent(T event) {
        this.messageConsumer.accept(event);
    }
}
