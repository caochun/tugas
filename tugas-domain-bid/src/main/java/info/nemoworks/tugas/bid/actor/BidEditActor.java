package info.nemoworks.tugas.bid.actor;

import info.nemoworks.tugas.bid.boundary.query.EditingQuery;
import info.nemoworks.tugas.framework.message.Message;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class BidEditActor {

    private Map<String, EditingQuery> queries = new HashMap<>();

    @PostConstruct
    public void registerEditQueryMessageSubscriber(){
        this.register(this::handleEditingMessage);
    }

    public void handleEditingMessage(Message<EditingQuery> message) {
        this.queries.put(message.getPayload().getSource().getId(), message.getPayload());
    }

}
