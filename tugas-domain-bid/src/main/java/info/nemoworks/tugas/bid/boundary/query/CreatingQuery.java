package info.nemoworks.tugas.bid.boundary.query;

import info.nemoworks.tugas.bid.domain.Bid;
import lombok.NonNull;

public class CreatingQuery extends BidQuery {
    public CreatingQuery(@NonNull Bid bid) {
        super(bid);
    }
}