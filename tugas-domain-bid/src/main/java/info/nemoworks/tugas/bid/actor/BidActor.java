package info.nemoworks.tugas.bid.actor;

import info.nemoworks.tugas.bid.boundary.command.CreateCommand;
import info.nemoworks.tugas.bid.boundary.query.BidQuery;
import info.nemoworks.tugas.bid.domain.BidService;
import info.nemoworks.tugas.framework.actor.Actor;
import info.nemoworks.tugas.framework.messaging.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BidActor extends Actor {

    private BidService bidService;

    @Autowired
    public void setBidService(BidService bidService) {
        this.bidService = bidService;
    }

    @PostConstruct
    public void registerCommandSubscribers() {
        super.<Message<CreateCommand>>register(this::handleCreateCommandMessage);
    }

    private void handleCreateCommandMessage(Message<CreateCommand> message) {
        this.bidService.handleCreateCommand(message.getPayload());
    }

    public void pubQueryMessage(BidQuery bidQuery) {
        if (null == bidQuery) return;
        else {
            pub(new Message<>(this, bidQuery));
        }
    }
}
