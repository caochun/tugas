package info.nemoworks.tugas.framework.message;

import org.springframework.context.ApplicationListener;

import java.util.function.Consumer;

public class Subscriber<T extends Message> implements ApplicationListener<T> {

    private Consumer<T> consumer;

    public Subscriber(Consumer<T> consumer) {
        this.consumer = consumer;
    }

    @Override
    public void onApplicationEvent(T event) {
        this.consumer.accept(event);
    }
}
