package info.nemoworks.tugas.bid.actor;

import info.nemoworks.tugas.bid.boundary.command.CreateCommand;
import info.nemoworks.tugas.bid.boundary.query.CreatingQuery;
import info.nemoworks.tugas.framework.actor.Actor;
import info.nemoworks.tugas.framework.messaging.Message;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class BidCreateActor extends Actor {

    private Map<String, CreatingQuery> queries = new HashMap<>();


    @PostConstruct
    public void registerQuerySubscriber() {
        super.register(this::handleCreatingQueryMessage);
    }

    private void handleCreatingQueryMessage(Message<CreatingQuery> message) {
        LoggerFactory.getLogger(BidCreateActor.class).info("handling bid " + message.getPayload().getSource().getId());
        this.handleCreating(message.getPayload());
    }

    public void handleCreating(CreatingQuery query) {
        this.queries.put(query.getSource().getId(), query);
    }

    public void pubCreateCommandMessage() {
        queries.values().stream().forEach(creatingQuery -> {
            this.pub(new Message<CreateCommand>(this, new CreateCommand(creatingQuery.getSource(), "abc", this.toString())));
        });

    }


}
