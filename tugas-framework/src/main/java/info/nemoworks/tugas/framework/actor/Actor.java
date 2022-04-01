package info.nemoworks.tugas.framework.actor;

import info.nemoworks.tugas.framework.messaging.Message;
import info.nemoworks.tugas.framework.messaging.MessageStub;
import info.nemoworks.tugas.framework.messaging.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public abstract class Actor {

    private MessageStub stub;

    @Autowired
    public void setStub(MessageStub stub) {
        this.stub = stub;
    }

    public MessageStub getStub(){
        return this.stub;
    }

    public void pub(Message<?> message){
        this.stub.pub(message);
    }

    public <T extends Message> void register(Consumer<T> subscriber){
        this.stub.register(new Subscriber<>(subscriber));
    }
}
