package info.nemoworks.tugas.bid.actor;

import info.nemoworks.tugas.bid.boundary.query.ApprovingQuery;
import info.nemoworks.tugas.framework.message.Message;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class BidApproveActor {
    private Map<String, ApprovingQuery> queries = new HashMap<>();

    @PostConstruct
    public void subscribeApprovingQueryMessage() {
        this.register(this::handleApprovingMessage);
    }

    public void handleApprovingMessage(Message<ApprovingQuery> query) {
        LoggerFactory.getLogger(BidApproveActor.class).info("handling " + query.getPayload().getSource().getId());
        this.queries.put(query.getPayload().getSource().getId(), query.getPayload());
    }
}
