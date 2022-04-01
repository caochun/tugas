package info.nemoworks.tugas.bid.boundary.query;

import info.nemoworks.tugas.bid.domain.Bid;
import info.nemoworks.tugas.framework.boundary.Query;
import lombok.NonNull;

public class BidQuery extends Query<Bid> {

    public BidQuery(@NonNull Bid bid) {
        super(bid);
    }

    public static final String APPROVING = "approve";
    public static final String EDITING = "editing";
    public static final String CREATING = "created";

}
