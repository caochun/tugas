package info.nemoworks.tugas.framework.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MessageStub {


    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    private ConfigurableApplicationContext applicationContext;

    @Autowired
    public void setApplicationContext(ConfigurableApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void pub(Message<?> message){
        applicationEventPublisher.publishEvent(message);
    }

    public void register(Subscriber subscriber){
        applicationContext.addApplicationListener(subscriber);
    }

}
