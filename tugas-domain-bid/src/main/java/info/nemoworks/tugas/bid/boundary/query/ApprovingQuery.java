package info.nemoworks.tugas.bid.boundary.query;

import info.nemoworks.tugas.bid.domain.Bid;
import lombok.NonNull;

public class ApprovingQuery extends BidQuery {
    public ApprovingQuery(@NonNull Bid bid) {
        super(bid);
    }
}
