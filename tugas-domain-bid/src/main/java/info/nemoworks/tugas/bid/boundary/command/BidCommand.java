package info.nemoworks.tugas.bid.boundary.command;

import info.nemoworks.tugas.bid.domain.Bid;
import info.nemoworks.tugas.framework.boundary.Command;
import lombok.NonNull;

public class BidCommand extends Command<Bid> {

    public BidCommand(@NonNull Bid target) {
        super(target);
    }
}
