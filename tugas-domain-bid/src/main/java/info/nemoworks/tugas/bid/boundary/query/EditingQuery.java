package info.nemoworks.tugas.bid.boundary.query;

import info.nemoworks.tugas.bid.domain.Bid;
import lombok.NonNull;

public class EditingQuery extends BidQuery {
    public EditingQuery(@NonNull Bid bid) {
        super(bid);
    }
}
