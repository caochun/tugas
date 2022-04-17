package info.nemoworks.tugas.framework.actor;

import info.nemoworks.tugas.framework.domain.Entity;
import info.nemoworks.tugas.framework.domain.QCRService;
import info.nemoworks.tugas.framework.message.Message;
import info.nemoworks.tugas.framework.message.MessageStub;
import info.nemoworks.tugas.framework.message.MessageListener;
import org.apache.commons.scxml2.model.EnterableState;
import org.apache.commons.scxml2.model.Transition;
import org.apache.commons.scxml2.model.TransitionTarget;
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

    public MessageStub getStub() {
        return this.stub;
    }

    public void pub(Message<?> message) {
        this.stub.pub(message);
    }

    public <M extends Message> void register(Consumer<M> subscriber) {
        this.stub.register(new MessageListener<>(subscriber));
    }

}
